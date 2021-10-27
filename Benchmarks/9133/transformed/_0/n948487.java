class n948487 {
	public static boolean decodeFileToFile(String nwk45hmN, String H6DEZNvY) {
		boolean Oxi5HFzg = false;
		java.io.InputStream zz2QdsGV = null;
		java.io.OutputStream zaZfPlEC = null;
		try {
			zz2QdsGV = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(nwk45hmN)),
					Base64.DECODE);
			zaZfPlEC = new java.io.BufferedOutputStream(new java.io.FileOutputStream(H6DEZNvY));
			byte[] gYsRdwmO = new byte[65536];
			int Itmig7T7 = -1;
			while ((Itmig7T7 = zz2QdsGV.read(gYsRdwmO)) >= 0) {
				zaZfPlEC.write(gYsRdwmO, 0, Itmig7T7);
			}
			Oxi5HFzg = true;
		} catch (java.io.IOException zZ5rONRF) {
			zZ5rONRF.printStackTrace();
		} finally {
			try {
				zz2QdsGV.close();
			} catch (Exception mKg1Tkut) {
			}
			try {
				zaZfPlEC.close();
			} catch (Exception x1d482l5) {
			}
		}
		return Oxi5HFzg;
	}

}