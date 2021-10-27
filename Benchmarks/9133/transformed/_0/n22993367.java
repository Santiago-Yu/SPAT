class n22993367 {
	public static boolean encodeFileToFile(String ufIj22mG, String MxyV1ThS) {
		boolean VyFoq5SD = false;
		java.io.InputStream fRVZsXqX = null;
		java.io.OutputStream lrtbQOEO = null;
		try {
			fRVZsXqX = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(ufIj22mG)),
					Base64.ENCODE);
			lrtbQOEO = new java.io.BufferedOutputStream(new java.io.FileOutputStream(MxyV1ThS));
			byte[] dDaqFYp3 = new byte[65536];
			int SQLAwXRF = -1;
			while ((SQLAwXRF = fRVZsXqX.read(dDaqFYp3)) >= 0) {
				lrtbQOEO.write(dDaqFYp3, 0, SQLAwXRF);
			}
			VyFoq5SD = true;
		} catch (java.io.IOException WPgSNPBd) {
			WPgSNPBd.printStackTrace();
		} finally {
			try {
				fRVZsXqX.close();
			} catch (Exception zIFtNqlg) {
			}
			try {
				lrtbQOEO.close();
			} catch (Exception KDGtNvLo) {
			}
		}
		return VyFoq5SD;
	}

}