class n22674018 {
	public void createTempFile(String hi3zUzLW) throws IOException {
		InputStream WnJNpq5R = Log4jImportCallableTest.class.getResourceAsStream(hi3zUzLW);
		if (WnJNpq5R == null) {
			fail("Couldn't resolve resource '" + hi3zUzLW + "'!");
		}
		inputFile = File.createTempFile("Import", "test");
		inputFile.delete();
		FileOutputStream fE05RRrR = new FileOutputStream(inputFile);
		IOUtils.copyLarge(WnJNpq5R, fE05RRrR);
		IOUtilities.closeQuietly(fE05RRrR);
	}

}