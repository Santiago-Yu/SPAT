class n23224029 {
	private HttpURLConnection getItemURLConnection(final String method, final String id, final byte[] data,
			final Map<String, List<String>> headers) throws IOException {
		if (null == m_bucket) {
			throw new IllegalArgumentException("bucket is not set");
		}
		final URL itemURL = new URL("http://" + m_host + "/" + m_bucket + "/" + id);
		final HttpURLConnection urlConn = (HttpURLConnection) itemURL.openConnection();
		urlConn.setRequestMethod(method);
		urlConn.setReadTimeout(READ_TIMEOUT);
		if (headers != null) {
			for (final Map.Entry<String, List<String>> me : headers.entrySet()) {
				for (final String v : me.getValue()) {
					urlConn.setRequestProperty(me.getKey(), v);
				}
			}
		}
		addAuthorization(urlConn, method, data);
		return urlConn;
	}

}