class n5518199 {
	protected String loadPage(String url_string) {
		try {
			URL url = new URL(url_string);
			HttpURLConnection connection = null;
			InputStream is = null;
			try {
				connection = (HttpURLConnection) url.openConnection();
				int response = connection.getResponseCode();
				if (response == HttpURLConnection.HTTP_ACCEPTED || response == HttpURLConnection.HTTP_OK) {
					is = connection.getInputStream();
					String page = "";
					for (; page.length() < MAX_PAGE_SIZE;) {
						byte[] buffer = new byte[2048];
						int len = is.read(buffer);
						if (len < 0) {
							break;
						}
						page += new String(buffer, 0, len);
					}
					return (page);
				} else {
					informFailure("httpinvalidresponse", "" + response);
					return (null);
				}
			} finally {
				try {
					if (is != null) {
						is.close();
					}
					if (connection != null) {
						connection.disconnect();
					}
				} catch (Throwable e) {
					Debug.printStackTrace(e);
				}
			}
		} catch (Throwable e) {
			informFailure("httploadfail", e.toString());
			return (null);
		}
	}

}