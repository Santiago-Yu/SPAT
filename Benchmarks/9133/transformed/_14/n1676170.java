class n1676170 {
	public HttpEntity execute(final HttpRequestBase request) throws IOException, ClientProtocolException {
		final HttpResponse response = mClient.execute(request);
		final int statusCode = response.getStatusLine().getStatusCode();
		if (HttpStatus.SC_OK == statusCode | HttpStatus.SC_CREATED == statusCode) {
			return response.getEntity();
		}
		return null;
	}

}