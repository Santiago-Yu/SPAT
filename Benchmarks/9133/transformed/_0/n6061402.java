class n6061402 {
	public static boolean encodeFileToFile(String bGkIHFSq, String ei53Q5UT) {
		boolean MQyMnMcg = false;
		java.io.InputStream WYalFIkK = null;
		java.io.OutputStream w8rvluQp = null;
		try {
			WYalFIkK = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(bGkIHFSq)),
					Base64.ENCODE);
			w8rvluQp = new java.io.BufferedOutputStream(new java.io.FileOutputStream(ei53Q5UT));
			byte[] VAv95K3j = new byte[65536];
			int TZSBty3G = -1;
			while ((TZSBty3G = WYalFIkK.read(VAv95K3j)) >= 0) {
				w8rvluQp.write(VAv95K3j, 0, TZSBty3G);
			}
			MQyMnMcg = true;
		} catch (java.io.IOException bjMr8QJ4) {
			bjMr8QJ4.printStackTrace();
		} finally {
			try {
				WYalFIkK.close();
			} catch (Exception clMGERTy) {
			}
			try {
				w8rvluQp.close();
			} catch (Exception z0xNHLZn) {
			}
		}
		return MQyMnMcg;
	}

}