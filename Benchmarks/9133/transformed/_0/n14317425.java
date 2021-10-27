class n14317425 {
	public static boolean encodeFileToFile(String xqzVcs0c, String nX1RB35w) {
		boolean TjFgsYS0 = false;
		java.io.InputStream iK4kXSUC = null;
		java.io.OutputStream OTCcX7sL = null;
		try {
			iK4kXSUC = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(xqzVcs0c)),
					Base64.ENCODE);
			OTCcX7sL = new java.io.BufferedOutputStream(new java.io.FileOutputStream(nX1RB35w));
			byte[] lfS3B8YI = new byte[65536];
			int ytH3Qfiy = -1;
			while ((ytH3Qfiy = iK4kXSUC.read(lfS3B8YI)) >= 0) {
				OTCcX7sL.write(lfS3B8YI, 0, ytH3Qfiy);
			}
			TjFgsYS0 = true;
		} catch (java.io.IOException Y8srI5Hd) {
			Y8srI5Hd.printStackTrace();
		} finally {
			try {
				iK4kXSUC.close();
			} catch (Exception MhqD0VLn) {
			}
			try {
				OTCcX7sL.close();
			} catch (Exception hPTNcdaI) {
			}
		}
		return TjFgsYS0;
	}

}