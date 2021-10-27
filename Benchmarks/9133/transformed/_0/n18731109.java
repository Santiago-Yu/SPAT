class n18731109 {
	public static boolean encodeFileToFile(String LcWJjbvv, String oPTHdlGu) {
		boolean lCpjP7By = false;
		java.io.InputStream l0erQE4v = null;
		java.io.OutputStream y1BysIGg = null;
		try {
			l0erQE4v = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(LcWJjbvv)),
					Base64.ENCODE);
			y1BysIGg = new java.io.BufferedOutputStream(new java.io.FileOutputStream(oPTHdlGu));
			byte[] TrAiWUX3 = new byte[65536];
			int KhFa9Ett = -1;
			while ((KhFa9Ett = l0erQE4v.read(TrAiWUX3)) >= 0) {
				y1BysIGg.write(TrAiWUX3, 0, KhFa9Ett);
			}
			lCpjP7By = true;
		} catch (java.io.IOException ZlaE6Jq8) {
			ZlaE6Jq8.printStackTrace();
		} finally {
			try {
				l0erQE4v.close();
			} catch (Exception V8sTTPPg) {
			}
			try {
				y1BysIGg.close();
			} catch (Exception zi3BuXbJ) {
			}
		}
		return lCpjP7By;
	}

}