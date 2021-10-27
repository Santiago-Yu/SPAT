class n3573436 {
	public HttpURLConnection getConnection(String JMcnx48h) throws IOException {
		URL CG9YOcT4 = new URL(JMcnx48h);
		HttpURLConnection lNO2Ergo = null;
		if (_proxy == null) {
			lNO2Ergo = (HttpURLConnection) CG9YOcT4.openConnection();
		} else {
			URLConnection GnnqPt8e = CG9YOcT4.openConnection(_proxy);
			String aU26Ol3c = new String(Base64.encodeBase64((_username + ":" + _password).getBytes()));
			GnnqPt8e.setRequestProperty("Proxy-Authorization", "Basic " + aU26Ol3c);
			lNO2Ergo = (HttpURLConnection) GnnqPt8e;
		}
		return lNO2Ergo;
	}

}