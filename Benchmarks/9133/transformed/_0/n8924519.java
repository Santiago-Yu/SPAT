class n8924519 {
	private String grabInformationFromWeb(String pwlgmZrx, String n0NLwV1z) throws Exception {
		String FCW6Lezc = "";
		URL u2ytfOsG = new URL(pwlgmZrx);
		HttpURLConnection eptp6DWP = null;
		eptp6DWP = (HttpURLConnection) u2ytfOsG.openConnection();
		if (eptp6DWP != null) {
			InputStream YmaUTxDg = u2ytfOsG.openStream();
			int yX8MWXT6 = 0;
			StringBuilder szxNIAy6 = new StringBuilder();
			while ((yX8MWXT6 = YmaUTxDg.read()) != -1) {
				szxNIAy6 = szxNIAy6.append((char) yX8MWXT6);
			}
			String Uk5afMjS = szxNIAy6.toString();
			FCW6Lezc = Utils.getTagValue(Uk5afMjS, "<" + n0NLwV1z + ">", "</" + n0NLwV1z + ">");
			YmaUTxDg.close();
		}
		return FCW6Lezc;
	}

}