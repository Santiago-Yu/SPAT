class n13124924 {
	public HttpURLConnection getURLConnection() throws IOException {
		HttpURLConnection jwkV5qZ4 = null;
		try {
			jwkV5qZ4 = (HttpURLConnection) _url.openConnection();
			jwkV5qZ4.setUseCaches(false);
			jwkV5qZ4.setRequestProperty("User-Agent", "WD-2.0");
			if (_doConditionalGET) {
				ResourceInfo kXxQ5S09 = (ResourceInfo) conditionalGetTable().get(_url.toString());
				if (kXxQ5S09 != null) {
					if (kXxQ5S09.lastModified != null) {
						jwkV5qZ4.setRequestProperty("If-Modified-Since", kXxQ5S09.lastModified);
					}
					if (kXxQ5S09.etag != null) {
						jwkV5qZ4.setRequestProperty("If-None-Match", kXxQ5S09.etag);
					}
				}
			}
			if (_username != null && _password != null) {
				String Kc9ZlDUF = _username + ":" + _password;
				String xVjUOFFR = Base64.encodeBytes(Kc9ZlDUF.getBytes());
				jwkV5qZ4.setRequestProperty("Authorization", "Basic " + xVjUOFFR);
			}
			_httpResponseCode = jwkV5qZ4.getResponseCode();
			if (_httpResponseCode == HttpURLConnection.HTTP_OK) {
				if (_doConditionalGET) {
					ResourceInfo ZKd0JZAA = new ResourceInfo();
					ZKd0JZAA.lastModified = jwkV5qZ4.getHeaderField("Last-Modified");
					ZKd0JZAA.etag = jwkV5qZ4.getHeaderField("ETag");
					Hashtable YZ4sYIYz = conditionalGetTable();
					YZ4sYIYz.put(_url.toString(), ZKd0JZAA);
					storeConditionalGetTable(YZ4sYIYz);
				}
			} else if (_httpResponseCode == HttpURLConnection.HTTP_NOT_MODIFIED) {
				_shouldGET = false;
			} else {
				Log.getInstance().write("Error getting url: " + _url + "\n" + "Error code: " + _httpResponseCode);
				_error = HTTP_NOT_OK;
				jwkV5qZ4.disconnect();
				jwkV5qZ4 = null;
			}
		} catch (SocketException fUhxhneW) {
			jwkV5qZ4.disconnect();
			jwkV5qZ4 = null;
			_error = NETWORK_DOWN;
		}
		return jwkV5qZ4;
	}

}