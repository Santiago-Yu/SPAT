class n18269744 {
	public static boolean encodeFileToFile(String JAQ9Wnja, String SwaGYoyg) {
		boolean sXLOggQZ = false;
		java.io.InputStream pXxJrCe8 = null;
		java.io.OutputStream MxAhq1HF = null;
		try {
			pXxJrCe8 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(JAQ9Wnja)),
					Base64.ENCODE);
			MxAhq1HF = new java.io.BufferedOutputStream(new java.io.FileOutputStream(SwaGYoyg));
			byte[] SnL95tHP = new byte[65536];
			int Eqsf0p6h = -1;
			while ((Eqsf0p6h = pXxJrCe8.read(SnL95tHP)) >= 0) {
				MxAhq1HF.write(SnL95tHP, 0, Eqsf0p6h);
			}
			sXLOggQZ = true;
		} catch (java.io.IOException z9oi5Ljv) {
			z9oi5Ljv.printStackTrace();
		} finally {
			try {
				pXxJrCe8.close();
			} catch (Exception odU3u8k6) {
			}
			try {
				MxAhq1HF.close();
			} catch (Exception HCvZ8lJb) {
			}
		}
		return sXLOggQZ;
	}

}