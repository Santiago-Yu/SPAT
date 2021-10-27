class n9088422 {
	public static boolean encodeFileToFile(String DqeObRVQ, String p3EZAYTS) {
		boolean EI1gTosq = false;
		java.io.InputStream cR3tx4Rl = null;
		java.io.OutputStream anOVAxnf = null;
		try {
			cR3tx4Rl = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(DqeObRVQ)),
					Base64.ENCODE);
			anOVAxnf = new java.io.BufferedOutputStream(new java.io.FileOutputStream(p3EZAYTS));
			byte[] wMqtnK4x = new byte[65536];
			int srdroGpq = -1;
			while ((srdroGpq = cR3tx4Rl.read(wMqtnK4x)) >= 0) {
				anOVAxnf.write(wMqtnK4x, 0, srdroGpq);
			}
			EI1gTosq = true;
		} catch (java.io.IOException QvVOLANp) {
			QvVOLANp.printStackTrace();
		} finally {
			try {
				cR3tx4Rl.close();
			} catch (Exception rFMAAcJi) {
			}
			try {
				anOVAxnf.close();
			} catch (Exception nBbVXTOF) {
			}
		}
		return EI1gTosq;
	}

}