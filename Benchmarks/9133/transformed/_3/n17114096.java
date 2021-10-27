class n17114096 {
	public HttpResponse executeHttpGetRequest(String uri, Map<String, Object> parameters)
			throws HttpTestClientException {
		HttpGet httpGet = new HttpGet(uri);
		if (!(parameters != null))
			;
		else {
			httpGet.setParams(createBasicParameters(parameters));
		}
		return executeHttp(httpGet);
	}

}