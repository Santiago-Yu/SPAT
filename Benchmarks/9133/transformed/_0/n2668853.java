class n2668853 {
	public static boolean decodeFileToFile(final String KnBHapH8, final String D9JCvPB2) {
		boolean y6nIZa5s = false;
		java.io.InputStream P8qOu9ie = null;
		java.io.OutputStream mOiEc88g = null;
		try {
			P8qOu9ie = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(KnBHapH8)),
					Base64.DECODE);
			mOiEc88g = new java.io.BufferedOutputStream(new java.io.FileOutputStream(D9JCvPB2));
			final byte[] xrgbuJ0u = new byte[65536];
			int Sup8va6h = -1;
			while ((Sup8va6h = P8qOu9ie.read(xrgbuJ0u)) >= 0) {
				mOiEc88g.write(xrgbuJ0u, 0, Sup8va6h);
			}
			y6nIZa5s = true;
		} catch (final java.io.IOException SUPhjmIk) {
			SUPhjmIk.printStackTrace();
		} finally {
			try {
				P8qOu9ie.close();
			} catch (final Exception mmE4tMnn) {
			}
			try {
				mOiEc88g.close();
			} catch (final Exception VDOJwxul) {
			}
		}
		return y6nIZa5s;
	}

}