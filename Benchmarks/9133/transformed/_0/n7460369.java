class n7460369 {
	public static boolean encodeFileToFile(String xWIIMa8A, String H8exG0MP) {
		boolean zMtbHcDP = false;
		java.io.InputStream FTXfrNlN = null;
		java.io.OutputStream FLvVVHGn = null;
		try {
			FTXfrNlN = new Base64.B64InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(xWIIMa8A)),
					Base64.ENCODE);
			FLvVVHGn = new java.io.BufferedOutputStream(new java.io.FileOutputStream(H8exG0MP));
			byte[] VnrnpCMK = new byte[65536];
			int RPZ45oIh = -1;
			while ((RPZ45oIh = FTXfrNlN.read(VnrnpCMK)) >= 0) {
				FLvVVHGn.write(VnrnpCMK, 0, RPZ45oIh);
			}
			zMtbHcDP = true;
		} catch (java.io.IOException nyY85Qjz) {
			nyY85Qjz.printStackTrace();
		} finally {
			try {
				FTXfrNlN.close();
			} catch (Exception QNzPJ4Qw) {
			}
			try {
				FLvVVHGn.close();
			} catch (Exception G0vJ1utn) {
			}
		}
		return zMtbHcDP;
	}

}