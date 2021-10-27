class n9693856 {
	public static boolean encodeFileToFile(String p6347SA6, String KLhzVuqQ) {
		boolean n1tWAeqS = false;
		java.io.InputStream yxizf8Qk = null;
		java.io.OutputStream nP8YmRgo = null;
		try {
			yxizf8Qk = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(p6347SA6)),
					Base64.ENCODE);
			nP8YmRgo = new java.io.BufferedOutputStream(new java.io.FileOutputStream(KLhzVuqQ));
			byte[] NXmvnspa = new byte[65536];
			int Chpss5C8 = -1;
			while ((Chpss5C8 = yxizf8Qk.read(NXmvnspa)) >= 0) {
				nP8YmRgo.write(NXmvnspa, 0, Chpss5C8);
			}
			n1tWAeqS = true;
		} catch (java.io.IOException J3YGCYOo) {
			J3YGCYOo.printStackTrace();
		} finally {
			try {
				yxizf8Qk.close();
			} catch (Exception KjdJDGWI) {
			}
			try {
				nP8YmRgo.close();
			} catch (Exception cT0taSWn) {
			}
		}
		return n1tWAeqS;
	}

}