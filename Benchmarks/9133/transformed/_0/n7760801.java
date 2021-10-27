class n7760801 {
	public static boolean decodeFileToFile(String BOADAEWs, String Z5MuGIG1) {
		boolean Eh1BO4Bg = false;
		java.io.InputStream st8zIDZE = null;
		java.io.OutputStream s9WFplB9 = null;
		try {
			st8zIDZE = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(BOADAEWs)),
					Base64.DECODE);
			s9WFplB9 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(Z5MuGIG1));
			byte[] rbY7cZcn = new byte[65536];
			int Ab9MfjLN = -1;
			while ((Ab9MfjLN = st8zIDZE.read(rbY7cZcn)) >= 0) {
				s9WFplB9.write(rbY7cZcn, 0, Ab9MfjLN);
			}
			Eh1BO4Bg = true;
		} catch (java.io.IOException y6Bx9fbZ) {
			y6Bx9fbZ.printStackTrace();
		} finally {
			try {
				st8zIDZE.close();
			} catch (Exception vgVygeXZ) {
			}
			try {
				s9WFplB9.close();
			} catch (Exception ebTDTiki) {
			}
		}
		return Eh1BO4Bg;
	}

}