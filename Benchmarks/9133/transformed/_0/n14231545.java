class n14231545 {
	public void createTempFile(String JgpH7c3W) throws IOException {
		InputStream i71mpI0T = JulImportCallableTest.class.getResourceAsStream(JgpH7c3W);
		if (i71mpI0T == null) {
			fail("Couldn't resolve resource '" + JgpH7c3W + "'!");
		}
		inputFile = File.createTempFile("Import", "test");
		inputFile.delete();
		FileOutputStream xfiq5vcU = new FileOutputStream(inputFile);
		IOUtils.copyLarge(i71mpI0T, xfiq5vcU);
		IOUtilities.closeQuietly(xfiq5vcU);
	}

}