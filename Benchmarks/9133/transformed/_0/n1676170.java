class n1676170 {
	public HttpEntity execute(final HttpRequestBase S3bjqJ74) throws IOException, ClientProtocolException {
		final HttpResponse GrGTBsdR = mClient.execute(S3bjqJ74);
		final int rIlqXwgO = GrGTBsdR.getStatusLine().getStatusCode();
		if (rIlqXwgO == HttpStatus.SC_OK | rIlqXwgO == HttpStatus.SC_CREATED) {
			return GrGTBsdR.getEntity();
		}
		return null;
	}

}