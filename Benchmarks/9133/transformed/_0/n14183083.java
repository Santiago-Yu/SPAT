class n14183083 {
	public static boolean encodeFileToFile(String yxrrFlBG, String VZNk2zae) {
		boolean pVj4jnKN = false;
		java.io.InputStream DLWHSYuP = null;
		java.io.OutputStream JwTQQzs4 = null;
		try {
			DLWHSYuP = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(yxrrFlBG)),
					Base64.ENCODE);
			JwTQQzs4 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(VZNk2zae));
			byte[] Y1e0f2li = new byte[65536];
			int Pyfn6PYD = -1;
			while ((Pyfn6PYD = DLWHSYuP.read(Y1e0f2li)) >= 0) {
				JwTQQzs4.write(Y1e0f2li, 0, Pyfn6PYD);
			}
			pVj4jnKN = true;
		} catch (java.io.IOException XFW8OSxn) {
			XFW8OSxn.printStackTrace();
		} finally {
			try {
				DLWHSYuP.close();
			} catch (Exception G4D19EXc) {
			}
			try {
				JwTQQzs4.close();
			} catch (Exception MuH40fSn) {
			}
		}
		return pVj4jnKN;
	}

}