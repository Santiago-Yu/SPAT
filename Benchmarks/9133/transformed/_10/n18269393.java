class n18269393 {
	public static File getClassLoaderFile(String filename) throws IOException {
		Resource resource = new ClassPathResource(filename);
		InputStream is = null;
		try {
			return resource.getFile();
		} catch (IOException e) {
		}
		FileOutputStream os = null;
		try {
			String tempFilename = RandomStringUtils.randomAlphanumeric(20);
			File file = File.createTempFile(tempFilename, null);
			os = new FileOutputStream(file);
			is = resource.getInputStream();
			IOUtils.copy(is, os);
			return file;
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}

}