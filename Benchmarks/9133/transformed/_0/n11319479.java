class n11319479 {
	public static boolean encodeFileToFile(String kGajg7lf, String sgN6f5ur) {
		boolean Qpb3HC5C = false;
		java.io.InputStream uU7vwHCc = null;
		java.io.OutputStream RUKmvRg2 = null;
		try {
			uU7vwHCc = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(kGajg7lf)),
					Base64.ENCODE);
			RUKmvRg2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(sgN6f5ur));
			byte[] tluIMzfn = new byte[65536];
			int gXTZWulu = -1;
			while ((gXTZWulu = uU7vwHCc.read(tluIMzfn)) >= 0) {
				RUKmvRg2.write(tluIMzfn, 0, gXTZWulu);
			}
			Qpb3HC5C = true;
		} catch (java.io.IOException LC3Iy4TZ) {
			LC3Iy4TZ.printStackTrace();
		} finally {
			try {
				uU7vwHCc.close();
			} catch (Exception fsTRNml9) {
			}
			try {
				RUKmvRg2.close();
			} catch (Exception pOHJMZOF) {
			}
		}
		return Qpb3HC5C;
	}

}