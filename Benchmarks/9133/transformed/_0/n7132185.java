class n7132185 {
	public static boolean encodeFileToFile(String c32ykjZB, String ATJn0PVl) {
		boolean qO2lERXU = false;
		java.io.InputStream ADgQgHib = null;
		java.io.OutputStream BbRnROdA = null;
		try {
			ADgQgHib = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(c32ykjZB)),
					Base64.ENCODE);
			BbRnROdA = new java.io.BufferedOutputStream(new java.io.FileOutputStream(ATJn0PVl));
			byte[] tsHoIjls = new byte[65536];
			int RBnLttVI = -1;
			while ((RBnLttVI = ADgQgHib.read(tsHoIjls)) >= 0) {
				BbRnROdA.write(tsHoIjls, 0, RBnLttVI);
			}
			qO2lERXU = true;
		} catch (java.io.IOException WNL1e03a) {
			WNL1e03a.printStackTrace();
		} finally {
			try {
				ADgQgHib.close();
			} catch (Exception XtEEuBjo) {
			}
			try {
				BbRnROdA.close();
			} catch (Exception qg9YRSYJ) {
			}
		}
		return qO2lERXU;
	}

}