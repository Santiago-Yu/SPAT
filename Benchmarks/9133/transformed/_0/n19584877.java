class n19584877 {
	public static boolean encodeFileToFile(String NboWN8A4, String XqnESxxv) {
		boolean XSQ0Ddy3 = false;
		java.io.InputStream mg6ZI6iZ = null;
		java.io.OutputStream IDkJUh6y = null;
		try {
			mg6ZI6iZ = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(NboWN8A4)),
					Base64.ENCODE);
			IDkJUh6y = new java.io.BufferedOutputStream(new java.io.FileOutputStream(XqnESxxv));
			byte[] pY3vJ1MX = new byte[65536];
			int pm6U4Z1F = -1;
			while ((pm6U4Z1F = mg6ZI6iZ.read(pY3vJ1MX)) >= 0) {
				IDkJUh6y.write(pY3vJ1MX, 0, pm6U4Z1F);
			}
			XSQ0Ddy3 = true;
		} catch (java.io.IOException QZdUpzxS) {
			QZdUpzxS.printStackTrace();
		} finally {
			try {
				mg6ZI6iZ.close();
			} catch (Exception ZF3v39iq) {
			}
			try {
				IDkJUh6y.close();
			} catch (Exception DknblQxk) {
			}
		}
		return XSQ0Ddy3;
	}

}