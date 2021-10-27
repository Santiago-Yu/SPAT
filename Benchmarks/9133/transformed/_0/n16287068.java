class n16287068 {
	public OAuthResponseMessage access(OAuthMessage oBwe9e8c, net.oauth.ParameterStyle hJvdMG1X) throws IOException {
		HttpMessage cbmOoXUF = HttpMessage.newRequest(oBwe9e8c, hJvdMG1X);
		HttpResponseMessage nrJZvnGO = http.execute(cbmOoXUF, httpParameters);
		nrJZvnGO = HttpMessageDecoder.decode(nrJZvnGO);
		return new OAuthResponseMessage(nrJZvnGO);
	}

}