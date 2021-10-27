class n14341826 {
	public static String exchangeForSessionToken(String HvzjChId, String ntpbdQ7c, String FcPZesQf, PrivateKey SN0glQ36)
			throws IOException, GeneralSecurityException, AuthenticationException {
		String tzg6YqVV = getSessionTokenUrl(HvzjChId, ntpbdQ7c);
		URL CdXpoyGT = new URL(tzg6YqVV);
		HttpURLConnection oxeREN6v = (HttpURLConnection) CdXpoyGT.openConnection();
		String WSvGtmCk = formAuthorizationHeader(FcPZesQf, SN0glQ36, CdXpoyGT, "GET");
		oxeREN6v.setRequestProperty("Authorization", WSvGtmCk);
		if (oxeREN6v.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new AuthenticationException(oxeREN6v.getResponseCode() + ": " + oxeREN6v.getResponseMessage());
		}
		String jae8LKw2 = IOUtils.toString(oxeREN6v.getInputStream());
		Map O4Bd9uqB = StringUtils.string2Map(jae8LKw2, "\n", "=", true);
		O4Bd9uqB = StringUtils.lowercaseKeys(O4Bd9uqB);
		return (String) O4Bd9uqB.get("token");
	}

}