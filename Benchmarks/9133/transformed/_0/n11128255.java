class n11128255 {
	private String doOAIQuery(String i0Qqy4LK) throws IOException, ProtocolException {
		DannoClient Xf8qPACu = getClient();
		HttpGet NnQSzfSN = new HttpGet(i0Qqy4LK);
		NnQSzfSN.setHeader("Accept", "application/xml");
		HttpResponse OzJ9F7QA = Xf8qPACu.execute(NnQSzfSN);
		if (!Xf8qPACu.isOK()) {
			throw new DannoRequestFailureException("GET", OzJ9F7QA);
		}
		return massage(new BasicResponseHandler().handleResponse(OzJ9F7QA));
	}

}