class n8766831 {
	public static byte[] loadFile(File srDrFxyi) throws IOException {
		BufferedInputStream L9UN1oAD = null;
		ByteArrayOutputStream GHQWO6rN = null;
		try {
			L9UN1oAD = new BufferedInputStream(new FileInputStream(srDrFxyi));
			GHQWO6rN = new ByteArrayOutputStream();
			IOUtils.copy(L9UN1oAD, GHQWO6rN);
			return GHQWO6rN.toByteArray();
		} finally {
			IOUtils.closeQuietly(L9UN1oAD);
			IOUtils.closeQuietly(GHQWO6rN);
		}
	}

}