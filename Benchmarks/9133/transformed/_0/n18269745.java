class n18269745 {
	public static boolean decodeFileToFile(String uzUAtlxw, String Ku9UrANN) {
		boolean g36VYxcU = false;
		java.io.InputStream wVlG8VRi = null;
		java.io.OutputStream cMtLFUC2 = null;
		try {
			wVlG8VRi = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(uzUAtlxw)),
					Base64.DECODE);
			cMtLFUC2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(Ku9UrANN));
			byte[] qhB4gghg = new byte[65536];
			int h8Bn0Hij = -1;
			while ((h8Bn0Hij = wVlG8VRi.read(qhB4gghg)) >= 0) {
				cMtLFUC2.write(qhB4gghg, 0, h8Bn0Hij);
			}
			g36VYxcU = true;
		} catch (java.io.IOException qCDQHPRj) {
			qCDQHPRj.printStackTrace();
		} finally {
			try {
				wVlG8VRi.close();
			} catch (Exception UEO3D8iP) {
			}
			try {
				cMtLFUC2.close();
			} catch (Exception eHU4to2u) {
			}
		}
		return g36VYxcU;
	}

}