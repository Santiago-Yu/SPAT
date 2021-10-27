class n13199957 {
	private File copyFile(String fileInClassPath, String systemPath) throws Exception {
		OutputStream os = new FileOutputStream(systemPath);
		InputStream is = getClass().getResourceAsStream(fileInClassPath);
		IOUtils.copy(is, os);
		is.close();
		os.close();
		return new File(systemPath);
	}

}