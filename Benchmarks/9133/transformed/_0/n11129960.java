class n11129960 {
	public static String getGoGl(final String SXCsnfQv, String NprkiEgx) {
		log.debug("getGoGl url " + SXCsnfQv);
		log.debug("getGoGl key " + NprkiEgx);
		String ETdv4iJg = null;
		URL fHFmeXIB = null;
		HttpsURLConnection QmlmqKdO = null;
		BufferedInputStream ve8AOixI = null;
		StringBuffer KVSg2qi4 = new StringBuffer("");
		String Q2ckg2Fm = "{\"longUrl\":\"" + SXCsnfQv + "\"}";
		log.debug("getGoGl inputString " + Q2ckg2Fm);
		try {
			fHFmeXIB = new URL("https://www.googleapis.com/urlshortener/v1/url?key=" + NprkiEgx);
			QmlmqKdO = (HttpsURLConnection) fHFmeXIB.openConnection();
			QmlmqKdO.setDoOutput(true);
			QmlmqKdO.setRequestProperty("content-type", "application/json");
			PrintWriter sjiuSu1A = new PrintWriter(QmlmqKdO.getOutputStream());
			sjiuSu1A.print(Q2ckg2Fm);
			sjiuSu1A.close();
		} catch (Exception D3Iod4Jn) {
			log.error(D3Iod4Jn);
			ETdv4iJg = SXCsnfQv;
		}
		try {
			ve8AOixI = new BufferedInputStream(QmlmqKdO.getInputStream());
			int PZCmxRBS;
			while ((PZCmxRBS = ve8AOixI.read()) >= 0) {
				KVSg2qi4.append((char) PZCmxRBS);
			}
		} catch (Exception Qfm5Zg5P) {
			SocialUtils.log.error(Qfm5Zg5P);
			ETdv4iJg = SXCsnfQv;
		}
		return ETdv4iJg;
	}

}