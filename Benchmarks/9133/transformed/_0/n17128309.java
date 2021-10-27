class n17128309 {
	private void copyIntoFile(String qX0UEi1B, File uOD5J549) throws IOException {
		FileOutputStream uxNcfWkv = null;
		InputStream hwJNzOI8 = null;
		try {
			uxNcfWkv = FileUtils.openOutputStream(uOD5J549);
			hwJNzOI8 = GroovyInstanceTest.class.getResourceAsStream(qX0UEi1B);
			IOUtils.copy(hwJNzOI8, uxNcfWkv);
		} finally {
			IOUtils.closeQuietly(uxNcfWkv);
			IOUtils.closeQuietly(hwJNzOI8);
		}
	}

}