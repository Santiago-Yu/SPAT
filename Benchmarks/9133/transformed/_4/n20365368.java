class n20365368 {
	public HttpResponse execute(HttpRequest request) throws IOException {
		this.request = request;
		buildParams();
		String l = request.getUrl();
		l = (request instanceof HttpGet) ? l + "?" + params : l;
		URL url = new URL(l);
		conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(connectTimeout);
		conn.setReadTimeout(readTimeout);
		buildHeader();
		if (request instanceof HttpPost) {
			sendRequest();
		}
		readResponse();
		return this.response;
	}

}