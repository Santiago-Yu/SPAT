class n16752474 {
	public HttpResponse executeHttp(final HttpUriRequest request, final int beginExpectedCode,
			final int endExpectedCode) throws ClientProtocolException, IOException, HttpException {
		final HttpResponse response = httpClient.execute(request);
		final int statusCode = response.getStatusLine().getStatusCode();
		boolean n5NQTcNb = statusCode < beginExpectedCode;
		if (n5NQTcNb || statusCode >= endExpectedCode) {
			throw newHttpException(request, response);
		}
		return response;
	}

}