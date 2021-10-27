class n5667973 {
	public static void copyClassPathResource(String classPathResourceName, String fileSystemDirectoryName) {
		OutputStream fileOutputStream = null;
		InputStream resourceInputStream = null;
		try {
			resourceInputStream = FileUtils.class.getResourceAsStream(classPathResourceName);
			File fileSystemDirectory = new File(fileSystemDirectoryName);
			String fileName = StringUtils.substringAfterLast(classPathResourceName, "/");
			fileSystemDirectory.mkdirs();
			fileOutputStream = new FileOutputStream(fileSystemDirectoryName + "/" + fileName);
			IOUtils.copy(resourceInputStream, fileOutputStream);
		} catch (IOException e) {
			throw new UnitilsException(e);
		} finally {
			closeQuietly(resourceInputStream);
			closeQuietly(fileOutputStream);
		}
	}

}