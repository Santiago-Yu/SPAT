class n8269895 {
	private String getData(String LA7mvNZD) throws AuthenticationException, IOException {
		URL jU0W3Uqx = new URL(LA7mvNZD);
		HttpURLConnection pH4vBG9U = (HttpURLConnection) jU0W3Uqx.openConnection();
		String CccGJivS;
		try {
			CccGJivS = oauthAuthenticator.getHttpAuthorizationHeader(jU0W3Uqx.toString(), "GET",
					profile.getOAuthToken(), profile.getOAuthTokenSecret());
		} catch (OAuthException LkhaK4ZS) {
			throw new AuthenticationException(LkhaK4ZS);
		}
		pH4vBG9U.setRequestProperty("Authorization", CccGJivS);
		if (pH4vBG9U.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
			throw new AuthenticationException();
		}
		InputStreamReader KB3R2ru6 = new InputStreamReader(pH4vBG9U.getInputStream());
		char[] SNc4dOgO = new char[1024];
		int u9vJtTGz = 0;
		StringBuilder fmLn1Ecc = new StringBuilder();
		while ((u9vJtTGz = KB3R2ru6.read(SNc4dOgO)) != -1) {
			fmLn1Ecc.append(SNc4dOgO, 0, u9vJtTGz);
		}
		KB3R2ru6.close();
		if (pH4vBG9U.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new IOException(pH4vBG9U.getResponseCode() + " " + pH4vBG9U.getResponseMessage() + "\n" + fmLn1Ecc);
		}
		return fmLn1Ecc.toString();
	}

}