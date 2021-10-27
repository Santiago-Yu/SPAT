class n1421558 {
	public static boolean decodeFileToFile(String ZvveaHwp, String OqWw3oaJ) {
		boolean bhVNzSkV = false;
		java.io.InputStream FCmrFKHw = null;
		java.io.OutputStream WcyPRjbx = null;
		try {
			FCmrFKHw = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(ZvveaHwp)),
					Base64.DECODE);
			WcyPRjbx = new java.io.BufferedOutputStream(new java.io.FileOutputStream(OqWw3oaJ));
			byte[] p8i2Nlhk = new byte[65536];
			int LEnrtMeP = -1;
			while ((LEnrtMeP = FCmrFKHw.read(p8i2Nlhk)) >= 0) {
				WcyPRjbx.write(p8i2Nlhk, 0, LEnrtMeP);
			}
			bhVNzSkV = true;
		} catch (java.io.IOException ploCIhzc) {
			ploCIhzc.printStackTrace();
		} finally {
			try {
				FCmrFKHw.close();
			} catch (Exception zb1atVA9) {
			}
			try {
				WcyPRjbx.close();
			} catch (Exception NHbWZg1e) {
			}
		}
		return bhVNzSkV;
	}

}