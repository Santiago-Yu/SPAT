class n16752474 {
	public HttpResponse executeHttp(final HttpUriRequest vdI0YNAg, final int ptVrNtpu, final int zuxXOjnS)
			throws ClientProtocolException, IOException, HttpException {
		final HttpResponse fFdqD9Mr = httpClient.execute(vdI0YNAg);
		final int ZINFJIAy = fFdqD9Mr.getStatusLine().getStatusCode();
		if (ZINFJIAy < ptVrNtpu || ZINFJIAy >= zuxXOjnS) {
			throw newHttpException(vdI0YNAg, fFdqD9Mr);
		}
		return fFdqD9Mr;
	}

}