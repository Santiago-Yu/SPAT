class n16224017 {
	public static boolean encodeFileToFile(String xIPI7WBM, String w6farklL) {
		boolean v9B7XesK = false;
		java.io.InputStream NKrUU6lt = null;
		java.io.OutputStream shLXwOh8 = null;
		try {
			NKrUU6lt = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(xIPI7WBM)),
					Base64.ENCODE);
			shLXwOh8 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(w6farklL));
			byte[] An9TBXwc = new byte[65536];
			int SOQPyt7k = -1;
			while ((SOQPyt7k = NKrUU6lt.read(An9TBXwc)) >= 0) {
				shLXwOh8.write(An9TBXwc, 0, SOQPyt7k);
			}
			v9B7XesK = true;
		} catch (java.io.IOException zsBwP7Me) {
			zsBwP7Me.printStackTrace();
		} finally {
			try {
				NKrUU6lt.close();
			} catch (Exception xrD46R0q) {
			}
			try {
				shLXwOh8.close();
			} catch (Exception VpFOcGky) {
			}
		}
		return v9B7XesK;
	}

}