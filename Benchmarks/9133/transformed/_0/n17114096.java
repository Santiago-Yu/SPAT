class n17114096 {
	public HttpResponse executeHttpGetRequest(String pSUK5g3E, Map<String, Object> RPjRnSAR)
			throws HttpTestClientException {
		HttpGet eWKqPp1x = new HttpGet(pSUK5g3E);
		if (RPjRnSAR != null) {
			eWKqPp1x.setParams(createBasicParameters(RPjRnSAR));
		}
		return executeHttp(eWKqPp1x);
	}

}