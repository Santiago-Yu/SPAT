class n8793826 {
	public static boolean decodeFileToFile(String tfpTVLMR, String uxyxZZoq) {
		boolean rbqx6FiC = false;
		java.io.InputStream CNfrqMe7 = null;
		java.io.OutputStream Zg2NASj6 = null;
		try {
			CNfrqMe7 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(tfpTVLMR)),
					Base64.DECODE);
			Zg2NASj6 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(uxyxZZoq));
			byte[] HTDMR5Mn = new byte[65536];
			int GONgYErU = -1;
			while ((GONgYErU = CNfrqMe7.read(HTDMR5Mn)) >= 0) {
				Zg2NASj6.write(HTDMR5Mn, 0, GONgYErU);
			}
			rbqx6FiC = true;
		} catch (java.io.IOException xKRQXZaW) {
			xKRQXZaW.printStackTrace();
		} finally {
			try {
				CNfrqMe7.close();
			} catch (Exception uvfzifqr) {
			}
			try {
				Zg2NASj6.close();
			} catch (Exception OSSMYIRK) {
			}
		}
		return rbqx6FiC;
	}

}