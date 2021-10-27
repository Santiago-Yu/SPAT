class n367770 {
	public static boolean encodeFileToFile(String m5otJ5M5, String yR64iw6v) {
		boolean ya4wYIBA = false;
		java.io.InputStream gUFp89nB = null;
		java.io.OutputStream R6tzu8o3 = null;
		try {
			gUFp89nB = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(m5otJ5M5)),
					Base64.ENCODE);
			R6tzu8o3 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(yR64iw6v));
			byte[] ZhqDi6Ey = new byte[65536];
			int TJJhJLj1 = -1;
			while ((TJJhJLj1 = gUFp89nB.read(ZhqDi6Ey)) >= 0) {
				R6tzu8o3.write(ZhqDi6Ey, 0, TJJhJLj1);
			}
			ya4wYIBA = true;
		} catch (java.io.IOException Zy0Rynr4) {
			Zy0Rynr4.printStackTrace();
		} finally {
			try {
				gUFp89nB.close();
			} catch (Exception m5CdXG1k) {
			}
			try {
				R6tzu8o3.close();
			} catch (Exception vXBELRg9) {
			}
		}
		return ya4wYIBA;
	}

}