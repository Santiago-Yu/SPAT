class n4482355 {
	protected static byte[] downloadAndSendBinary(String T09WkFXA, boolean QBS6EEx1, File hwKvBEhP) throws IOException {
		URL G9bXIbDV = new URL(T09WkFXA);
		Authenticator.setDefault(new HTTPResourceAuthenticator());
		HTTPResourceAuthenticator.addURL(G9bXIbDV);
		logger.debug("Retrieving " + G9bXIbDV.toString());
		ByteArrayOutputStream SVUjQ28k = new ByteArrayOutputStream();
		URLConnection PMN2DC3f = G9bXIbDV.openConnection();
		PMN2DC3f.setRequestProperty("User-agent", "PS3 Media Server " + PMS.getVersion());
		InputStream Y4Lh9rlR = PMN2DC3f.getInputStream();
		FileOutputStream CSCNBHxX = null;
		if (QBS6EEx1 && hwKvBEhP != null) {
			CSCNBHxX = new FileOutputStream(hwKvBEhP);
		}
		byte Zr4iMWbD[] = new byte[4096];
		int RRkSctUp = -1;
		while ((RRkSctUp = Y4Lh9rlR.read(Zr4iMWbD)) > -1) {
			SVUjQ28k.write(Zr4iMWbD, 0, RRkSctUp);
			if (CSCNBHxX != null) {
				CSCNBHxX.write(Zr4iMWbD, 0, RRkSctUp);
			}
		}
		Y4Lh9rlR.close();
		if (CSCNBHxX != null) {
			CSCNBHxX.close();
		}
		return SVUjQ28k.toByteArray();
	}

}