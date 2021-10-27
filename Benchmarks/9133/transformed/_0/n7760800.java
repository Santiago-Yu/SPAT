class n7760800 {
	public static boolean encodeFileToFile(String foEBuAvg, String sEuj0s8J) {
		boolean qmVbdY0j = false;
		java.io.InputStream eoFoitfP = null;
		java.io.OutputStream Q7AbCDx4 = null;
		try {
			eoFoitfP = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(foEBuAvg)),
					Base64.ENCODE);
			Q7AbCDx4 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(sEuj0s8J));
			byte[] lKcHclZ4 = new byte[65536];
			int bQa1AztH = -1;
			while ((bQa1AztH = eoFoitfP.read(lKcHclZ4)) >= 0) {
				Q7AbCDx4.write(lKcHclZ4, 0, bQa1AztH);
			}
			qmVbdY0j = true;
		} catch (java.io.IOException Ed6pzOPf) {
			Ed6pzOPf.printStackTrace();
		} finally {
			try {
				eoFoitfP.close();
			} catch (Exception tTJF79Ua) {
			}
			try {
				Q7AbCDx4.close();
			} catch (Exception PE7VDHlo) {
			}
		}
		return qmVbdY0j;
	}

}