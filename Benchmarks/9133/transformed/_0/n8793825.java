class n8793825 {
	public static boolean encodeFileToFile(String bdDEyTgb, String OX3Sx2Ek) {
		boolean XSLgTLqE = false;
		java.io.InputStream QrA6j8s2 = null;
		java.io.OutputStream aaoXsFkk = null;
		try {
			QrA6j8s2 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(bdDEyTgb)),
					Base64.ENCODE);
			aaoXsFkk = new java.io.BufferedOutputStream(new java.io.FileOutputStream(OX3Sx2Ek));
			byte[] Nb7GkoxT = new byte[65536];
			int OcahNKc4 = -1;
			while ((OcahNKc4 = QrA6j8s2.read(Nb7GkoxT)) >= 0) {
				aaoXsFkk.write(Nb7GkoxT, 0, OcahNKc4);
			}
			XSLgTLqE = true;
		} catch (java.io.IOException hKyc9nLS) {
			hKyc9nLS.printStackTrace();
		} finally {
			try {
				QrA6j8s2.close();
			} catch (Exception j70xbK2K) {
			}
			try {
				aaoXsFkk.close();
			} catch (Exception cbln0DLS) {
			}
		}
		return XSLgTLqE;
	}

}