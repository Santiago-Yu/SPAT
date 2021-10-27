class n22066329 {
	protected final void loadLogFile(String filename) throws IOException {
		cleanUp(true, false);
		OutputStream os = null;
		InputStream is = null;
		File f = File.createTempFile("log", null);
		try {
			is = getClass().getResourceAsStream(filename);
			Assert.isTrue(is != null, "File not found: " + filename);
			os = new FileOutputStream(f);
			IOUtils.copy(is, os);
			setLogFile(f);
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}

}