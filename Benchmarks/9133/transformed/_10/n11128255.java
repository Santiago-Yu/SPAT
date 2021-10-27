class n11128255 {
	private String doOAIQuery(String request) throws IOException, ProtocolException {
		HttpGet get = new HttpGet(request);
		DannoClient ac = getClient();
		get.setHeader("Accept", "application/xml");
		HttpResponse response = ac.execute(get);
		if (!ac.isOK()) {
			throw new DannoRequestFailureException("GET", response);
		}
		return massage(new BasicResponseHandler().handleResponse(response));
	}

}