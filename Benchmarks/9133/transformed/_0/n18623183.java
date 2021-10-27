class n18623183 {
	public static boolean decodeFileToFile(String WSPM8KVE, String qOAxC9mC) {
		boolean Gh7p3c3B = false;
		java.io.InputStream Z0jkkuPc = null;
		java.io.OutputStream HE2NKuMy = null;
		try {
			Z0jkkuPc = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(WSPM8KVE)),
					Base64.DECODE);
			HE2NKuMy = new java.io.BufferedOutputStream(new java.io.FileOutputStream(qOAxC9mC));
			byte[] T6qDdqNc = new byte[65536];
			int ZzUlkyJF = -1;
			while ((ZzUlkyJF = Z0jkkuPc.read(T6qDdqNc)) >= 0) {
				HE2NKuMy.write(T6qDdqNc, 0, ZzUlkyJF);
			}
			Gh7p3c3B = true;
		} catch (java.io.IOException qbNCT8ui) {
			qbNCT8ui.printStackTrace();
		} finally {
			try {
				Z0jkkuPc.close();
			} catch (Exception FbN58brB) {
			}
			try {
				HE2NKuMy.close();
			} catch (Exception WcL7gazM) {
			}
		}
		return Gh7p3c3B;
	}

}