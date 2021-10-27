class n22674018 {
	public void createTempFile(String resourceName) throws IOException {
		InputStream input = Log4jImportCallableTest.class.getResourceAsStream(resourceName);
		if (null == input) {
			fail("Couldn't resolve resource '" + resourceName + "'!");
		}
		inputFile = File.createTempFile("Import", "test");
		inputFile.delete();
		FileOutputStream output = new FileOutputStream(inputFile);
		IOUtils.copyLarge(input, output);
		IOUtilities.closeQuietly(output);
	}

}