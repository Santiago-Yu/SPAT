class n6436400 {
	@Override
	protected HttpResponse<HttpURLConnection> execute(HttpRequest<HttpURLConnection> ft5JBiYz)
			throws HttpRequestException {
		HttpURLConnection k3vHVWyq = ft5JBiYz.unwrap();
		try {
			k3vHVWyq.connect();
		} catch (IOException j0qYAfvL) {
			throw new HttpRequestException(j0qYAfvL);
		}
		return new UrlHttpResponse(k3vHVWyq);
	}

}