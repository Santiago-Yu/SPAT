class n16190704 {
	public static String exchangeForSessionToken(String WlXcpswP, String Ych1MdSZ, String oMee0iC7, PrivateKey Fh951Del)
			throws IOException, GeneralSecurityException, AuthenticationException {
		String xaZJxXgD = getSessionTokenUrl(WlXcpswP, Ych1MdSZ);
		URL QvuWoSPo = new URL(xaZJxXgD);
		HttpURLConnection mkbZ2m7g = (HttpURLConnection) QvuWoSPo.openConnection();
		String KGT7LO6c = formAuthorizationHeader(oMee0iC7, Fh951Del, QvuWoSPo, "GET");
		mkbZ2m7g.setRequestProperty("Authorization", KGT7LO6c);
		if (mkbZ2m7g.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new AuthenticationException(mkbZ2m7g.getResponseCode() + ": " + mkbZ2m7g.getResponseMessage());
		}
		String t1BZRQcU = CharStreams.toString(new InputStreamReader(mkbZ2m7g.getInputStream(), Charsets.ISO_8859_1));
		Map<String, String> Z4C6fVeh = StringUtil.string2Map(t1BZRQcU, "\n", "=", true);
		Z4C6fVeh = StringUtil.lowercaseKeys(Z4C6fVeh);
		return Z4C6fVeh.get("token");
	}

}