class n17128309 {
	private void copyIntoFile(String resource, File output) throws IOException {
		InputStream in = null;
		FileOutputStream out = null;
		try {
			in = GroovyInstanceTest.class.getResourceAsStream(resource);
			out = FileUtils.openOutputStream(output);
			IOUtils.copy(in, out);
		} finally {
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(in);
		}
	}

}