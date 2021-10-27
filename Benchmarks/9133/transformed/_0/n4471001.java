class n4471001 {
	public static boolean decodeFileToFile(String hnm31pu9, String DGb0njnr) {
		boolean eM6Tcxly = false;
		java.io.InputStream q8E0EO5F = null;
		java.io.OutputStream C2a4LT0K = null;
		try {
			q8E0EO5F = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(hnm31pu9)),
					Base64.DECODE);
			C2a4LT0K = new java.io.BufferedOutputStream(new java.io.FileOutputStream(DGb0njnr));
			byte[] MVnLtNcQ = new byte[65536];
			int NshluL0D = -1;
			while ((NshluL0D = q8E0EO5F.read(MVnLtNcQ)) >= 0) {
				C2a4LT0K.write(MVnLtNcQ, 0, NshluL0D);
			}
			eM6Tcxly = true;
		} catch (java.io.IOException pwXiTqtR) {
			pwXiTqtR.printStackTrace();
		} finally {
			try {
				q8E0EO5F.close();
			} catch (Exception mENekk23) {
			}
			try {
				C2a4LT0K.close();
			} catch (Exception ae9uXxoR) {
			}
		}
		return eM6Tcxly;
	}

}