class n19643372 {
	public static boolean encodeFileToFile(String WBkxpBTE, String eeSxT5gd) {
		boolean hauH20o1 = false;
		java.io.InputStream rhhLrtwW = null;
		java.io.OutputStream HIEkVtpr = null;
		try {
			rhhLrtwW = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(WBkxpBTE)),
					Base64.ENCODE);
			HIEkVtpr = new java.io.BufferedOutputStream(new java.io.FileOutputStream(eeSxT5gd));
			byte[] AkjjwQap = new byte[65536];
			int MCh8tnAE = -1;
			while ((MCh8tnAE = rhhLrtwW.read(AkjjwQap)) >= 0) {
				HIEkVtpr.write(AkjjwQap, 0, MCh8tnAE);
			}
			hauH20o1 = true;
		} catch (java.io.IOException KkC8KWZz) {
			logger.error(Logger.SECURITY_FAILURE, "Problem encoding file to file", KkC8KWZz);
		} finally {
			try {
				rhhLrtwW.close();
			} catch (Exception TekeNjs2) {
			}
			try {
				HIEkVtpr.close();
			} catch (Exception MORb2U1V) {
			}
		}
		return hauH20o1;
	}

}