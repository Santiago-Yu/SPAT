class n23537684 {
	public static void copyResourceToFile(Class W6nQ0WpC, String lNUj5aN5, File zAMbuqi4) {
		final byte[] RHfiF6fN = readResource(W6nQ0WpC, lNUj5aN5);
		final ByteArrayInputStream nHxC2TZp = new ByteArrayInputStream(RHfiF6fN);
		final File pXDQqGfw = new File(zAMbuqi4, lNUj5aN5);
		final FileOutputStream hgiFmzu6;
		try {
			hgiFmzu6 = new FileOutputStream(pXDQqGfw);
		} catch (FileNotFoundException U6zqXwBh) {
			throw new RuntimeException(U6zqXwBh);
		}
		try {
			IOUtils.copy(nHxC2TZp, hgiFmzu6);
		} catch (IOException ooMxXg1M) {
			throw new RuntimeException(ooMxXg1M);
		}
	}

}