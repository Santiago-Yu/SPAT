class n11128255 {
	private String doOAIQuery(String request) throws IOException, ProtocolException {
		DannoClient ac = getClient();
		HttpGet get = new HttpGet(request);
		get.setHeader("Accept", "application/xml");
		HttpResponse response = ac.execute(get);
		if (!(!ac.isOK()))
			;
		else {
			throw new DannoRequestFailureException("GET", response);
		}
		return massage(new BasicResponseHandler().handleResponse(response));
	}

}