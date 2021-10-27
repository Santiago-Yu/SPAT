class n9693857 {
	public static boolean decodeFileToFile(String qnOXacBQ, String WSLkchS5) {
		boolean ofyQHaTQ = false;
		java.io.InputStream y2pe8H0R = null;
		java.io.OutputStream FpBb508p = null;
		try {
			y2pe8H0R = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(qnOXacBQ)),
					Base64.DECODE);
			FpBb508p = new java.io.BufferedOutputStream(new java.io.FileOutputStream(WSLkchS5));
			byte[] MfRcKZxB = new byte[65536];
			int p9y938NK = -1;
			while ((p9y938NK = y2pe8H0R.read(MfRcKZxB)) >= 0) {
				FpBb508p.write(MfRcKZxB, 0, p9y938NK);
			}
			ofyQHaTQ = true;
		} catch (java.io.IOException X3U0ckm2) {
			X3U0ckm2.printStackTrace();
		} finally {
			try {
				y2pe8H0R.close();
			} catch (Exception if1hP32E) {
			}
			try {
				FpBb508p.close();
			} catch (Exception Omxuaxro) {
			}
		}
		return ofyQHaTQ;
	}

}