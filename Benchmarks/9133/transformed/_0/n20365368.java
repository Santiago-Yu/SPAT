class n20365368 {
	public HttpResponse execute(HttpRequest xuXq69ci) throws IOException {
		this.request = xuXq69ci;
		buildParams();
		String jhQTEkLe = xuXq69ci.getUrl();
		if (xuXq69ci instanceof HttpGet) {
			jhQTEkLe = jhQTEkLe + "?" + params;
		}
		URL g3iLlYll = new URL(jhQTEkLe);
		conn = (HttpURLConnection) g3iLlYll.openConnection();
		conn.setConnectTimeout(connectTimeout);
		conn.setReadTimeout(readTimeout);
		buildHeader();
		if (xuXq69ci instanceof HttpPost) {
			sendRequest();
		}
		readResponse();
		return this.response;
	}

}