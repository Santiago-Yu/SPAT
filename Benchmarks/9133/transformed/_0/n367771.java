class n367771 {
	public static boolean decodeFileToFile(String nZNFHsoH, String JhCU1hOe) {
		boolean e6xQHNRo = false;
		java.io.InputStream elDqNXzz = null;
		java.io.OutputStream A1KwyKnK = null;
		try {
			elDqNXzz = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(nZNFHsoH)),
					Base64.DECODE);
			A1KwyKnK = new java.io.BufferedOutputStream(new java.io.FileOutputStream(JhCU1hOe));
			byte[] tFBuvr5p = new byte[65536];
			int snyy5lbR = -1;
			while ((snyy5lbR = elDqNXzz.read(tFBuvr5p)) >= 0) {
				A1KwyKnK.write(tFBuvr5p, 0, snyy5lbR);
			}
			e6xQHNRo = true;
		} catch (java.io.IOException nCHSzvpH) {
			nCHSzvpH.printStackTrace();
		} finally {
			try {
				elDqNXzz.close();
			} catch (Exception VaXMJFrK) {
			}
			try {
				A1KwyKnK.close();
			} catch (Exception H9a899hD) {
			}
		}
		return e6xQHNRo;
	}

}