class n13124924 {
	public HttpURLConnection getURLConnection() throws IOException {
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) _url.openConnection();
			conn.setUseCaches(false);
			conn.setRequestProperty("User-Agent", "WD-2.0");
			if (_doConditionalGET) {
				ResourceInfo ri = (ResourceInfo) conditionalGetTable().get(_url.toString());
				if (ri != null) {
					if (ri.lastModified != null) {
						conn.setRequestProperty("If-Modified-Since", ri.lastModified);
					}
					if (ri.etag != null) {
						conn.setRequestProperty("If-None-Match", ri.etag);
					}
				}
			}
			if (_username != null && _password != null) {
				String authenticationStr = _username + ":" + _password;
				String encodedAuthStr = Base64.encodeBytes(authenticationStr.getBytes());
				conn.setRequestProperty("Authorization", "Basic " + encodedAuthStr);
			}
			_httpResponseCode = conn.getResponseCode();
			if (_httpResponseCode == HttpURLConnection.HTTP_OK) {
				if (_doConditionalGET) {
					ResourceInfo ri = new ResourceInfo();
					ri.lastModified = conn.getHeaderField("Last-Modified");
					ri.etag = conn.getHeaderField("ETag");
					Hashtable table = conditionalGetTable();
					table.put(_url.toString(), ri);
					storeConditionalGetTable(table);
				}
			} else if (_httpResponseCode == HttpURLConnection.HTTP_NOT_MODIFIED) {
				_shouldGET = false;
			} else {
				Log.getInstance().write("Error getting url: " + _url + "\n" + "Error code: " + _httpResponseCode);
				_error = HTTP_NOT_OK;
				conn.disconnect();
				conn = null;
			}
		} catch (SocketException ex) {
			conn.disconnect();
			_error = NETWORK_DOWN;
			conn = null;
		}
		return conn;
	}

}