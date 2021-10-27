class n8269896 {
	private String postData(String d08JwHzD, String CoZTRlIP) throws AuthenticationException, IOException {
		URL rR5xQ1p9 = new URL(d08JwHzD);
		HttpURLConnection EPuPvzmQ = (HttpURLConnection) rR5xQ1p9.openConnection();
		EPuPvzmQ.setRequestMethod("POST");
		EPuPvzmQ.setDoOutput(true);
		String Cj50qLAz;
		try {
			Cj50qLAz = oauthAuthenticator.getHttpAuthorizationHeader(rR5xQ1p9.toString(), "POST",
					profile.getOAuthToken(), profile.getOAuthTokenSecret());
		} catch (OAuthException BDYe8ceK) {
			throw new AuthenticationException(BDYe8ceK);
		}
		EPuPvzmQ.setRequestProperty("Authorization", Cj50qLAz);
		EPuPvzmQ.setRequestProperty("Content-Type", "application/atom+xml");
		BufferedWriter LRBBgvBM = new BufferedWriter(new OutputStreamWriter(EPuPvzmQ.getOutputStream()));
		LRBBgvBM.write(CoZTRlIP);
		LRBBgvBM.close();
		if (EPuPvzmQ.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
			throw new AuthenticationException();
		}
		InputStreamReader sJmXRMeD = new InputStreamReader(EPuPvzmQ.getInputStream());
		char[] irCzITXb = new char[1024];
		int H51fouMA = 0;
		StringBuilder eD2bC77W = new StringBuilder();
		while ((H51fouMA = sJmXRMeD.read(irCzITXb)) != -1) {
			eD2bC77W.append(irCzITXb, 0, H51fouMA);
		}
		sJmXRMeD.close();
		if (EPuPvzmQ.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new IOException(EPuPvzmQ.getResponseCode() + " " + EPuPvzmQ.getResponseMessage() + "\n" + eD2bC77W);
		}
		return eD2bC77W.toString();
	}

}