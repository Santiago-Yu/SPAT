class n8156588 {
	private static final BufferedInputStream createInputStreamFromRemoteUrl(String uri,
			ClientConnectionManager connectionManager) {
		InputStream contentInput = null;
		if (connectionManager == null) {
			try {
				URL url = new URI(uri).toURL();
				URLConnection conn = url.openConnection();
				conn.connect();
				contentInput = conn.getInputStream();
			} catch (Exception e) {
				Log.w(TAG, "Request failed: " + uri);
				e.printStackTrace();
				return null;
			}
		} else {
			final DefaultHttpClient mHttpClient = new DefaultHttpClient(connectionManager, HTTP_PARAMS);
			HttpUriRequest request = new HttpGet(uri);
			HttpResponse httpResponse = null;
			try {
				httpResponse = mHttpClient.execute(request);
				HttpEntity entity = httpResponse.getEntity();
				contentInput = (entity != null) ? entity.getContent() : contentInput;
			} catch (Exception e) {
				Log.w(TAG, "Request failed: " + request.getURI());
				return null;
			}
		}
		if (contentInput != null) {
			return new BufferedInputStream(contentInput, 4096);
		} else {
			return null;
		}
	}

}