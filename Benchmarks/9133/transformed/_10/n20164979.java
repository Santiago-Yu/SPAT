class n20164979 {
	private void handleUpload(CommonsMultipartFile file, String newFileName, String uploadDir)
			throws IOException, FileNotFoundException {
		File dirPath = new File(uploadDir);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		OutputStream bos = new FileOutputStream(uploadDir + newFileName);
		InputStream stream = file.getInputStream();
		IOUtils.copy(stream, bos);
	}

}