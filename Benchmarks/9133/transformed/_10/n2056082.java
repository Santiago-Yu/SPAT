class n2056082 {
	protected void setTestContent(IDfDocument document, String testFileName) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream testFileIs = new BufferedInputStream(FileHelper.getFileAsStreamFromClassPath(testFileName));
		IOUtils.copy(testFileIs, baos);
		String contentType = formatHelper.getFormatForExtension(FileHelper.getFileExtension(testFileName));
		document.setContentType(contentType);
		document.setContent(baos);
	}

}