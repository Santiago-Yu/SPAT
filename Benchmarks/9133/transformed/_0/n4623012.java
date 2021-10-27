class n4623012 {
	public static boolean encodeFileToFile(String BGLbxHHA, String TXPOpKUg) {
		boolean X35Eb42d = false;
		java.io.InputStream pakSRyzH = null;
		java.io.OutputStream ANHzlT5T = null;
		try {
			pakSRyzH = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(BGLbxHHA)),
					Base64.ENCODE);
			ANHzlT5T = new java.io.BufferedOutputStream(new java.io.FileOutputStream(TXPOpKUg));
			byte[] uQjB9G0p = new byte[65536];
			int m5CUm3St = -1;
			while ((m5CUm3St = pakSRyzH.read(uQjB9G0p)) >= 0) {
				ANHzlT5T.write(uQjB9G0p, 0, m5CUm3St);
			}
			X35Eb42d = true;
		} catch (java.io.IOException DpOTiaLK) {
			DpOTiaLK.printStackTrace();
		} finally {
			try {
				pakSRyzH.close();
			} catch (Exception JRfjBDkM) {
			}
			try {
				ANHzlT5T.close();
			} catch (Exception KqPZpfd3) {
			}
		}
		return X35Eb42d;
	}

}