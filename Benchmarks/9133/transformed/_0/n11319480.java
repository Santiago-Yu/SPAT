class n11319480 {
	public static boolean decodeFileToFile(String qHUFwINo, String GTuhAtkm) {
		boolean cZGdGwis = false;
		java.io.InputStream sFoJVwyx = null;
		java.io.OutputStream qrNsfVLH = null;
		try {
			sFoJVwyx = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(qHUFwINo)),
					Base64.DECODE);
			qrNsfVLH = new java.io.BufferedOutputStream(new java.io.FileOutputStream(GTuhAtkm));
			byte[] ZEYsedfF = new byte[65536];
			int JLlyME4Y = -1;
			while ((JLlyME4Y = sFoJVwyx.read(ZEYsedfF)) >= 0) {
				qrNsfVLH.write(ZEYsedfF, 0, JLlyME4Y);
			}
			cZGdGwis = true;
		} catch (java.io.IOException zG7p4U5P) {
			zG7p4U5P.printStackTrace();
		} finally {
			try {
				sFoJVwyx.close();
			} catch (Exception vKiZaoXg) {
			}
			try {
				qrNsfVLH.close();
			} catch (Exception XGbC01kA) {
			}
		}
		return cZGdGwis;
	}

}