class n2668863 {
	public static boolean encodeFileToFile(final String wDSLv0CO, final String kapumdho) {
		boolean Gihgdlz4 = false;
		java.io.InputStream iW0mSeFM = null;
		java.io.OutputStream cTPXqxS0 = null;
		try {
			iW0mSeFM = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(wDSLv0CO)),
					Base64.ENCODE);
			cTPXqxS0 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(kapumdho));
			final byte[] Rlnf6al2 = new byte[65536];
			int ofdHQkBh = -1;
			while ((ofdHQkBh = iW0mSeFM.read(Rlnf6al2)) >= 0) {
				cTPXqxS0.write(Rlnf6al2, 0, ofdHQkBh);
			}
			Gihgdlz4 = true;
		} catch (final java.io.IOException o1aIk767) {
			o1aIk767.printStackTrace();
		} finally {
			try {
				iW0mSeFM.close();
			} catch (final Exception VGpO1bRW) {
			}
			try {
				cTPXqxS0.close();
			} catch (final Exception ychuyBX4) {
			}
		}
		return Gihgdlz4;
	}

}