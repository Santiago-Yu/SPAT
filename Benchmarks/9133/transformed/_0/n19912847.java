class n19912847 {
	public static boolean encodeFileToFile(String JRKiCmh6, String MUosBCGL) {
		boolean KrL9crGu = false;
		java.io.InputStream R3umVAvR = null;
		java.io.OutputStream DIQKzYA9 = null;
		try {
			R3umVAvR = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(JRKiCmh6)),
					Base64.ENCODE);
			DIQKzYA9 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(MUosBCGL));
			byte[] YF6c8IG3 = new byte[65536];
			int bxG3EaIH = -1;
			while ((bxG3EaIH = R3umVAvR.read(YF6c8IG3)) >= 0) {
				DIQKzYA9.write(YF6c8IG3, 0, bxG3EaIH);
			}
			KrL9crGu = true;
		} catch (java.io.IOException ludwptVg) {
			ludwptVg.printStackTrace();
		} finally {
			try {
				R3umVAvR.close();
			} catch (Exception nfWypzRP) {
			}
			try {
				DIQKzYA9.close();
			} catch (Exception QLEEvt8k) {
			}
		}
		return KrL9crGu;
	}

}