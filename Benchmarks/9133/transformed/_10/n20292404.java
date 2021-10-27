class n20292404 {
	protected void convertInternal(InputStream inputStream, DocumentFormat inputFormat, OutputStream outputStream,
			DocumentFormat outputFormat) {
		File outputFile = null;
		File inputFile = null;
		try {
			OutputStream inputFileStream = null;
			inputFile = File.createTempFile("document", "." + inputFormat.getFileExtension());
			try {
				inputFileStream = new FileOutputStream(inputFile);
				IOUtils.copy(inputStream, inputFileStream);
			} finally {
				IOUtils.closeQuietly(inputFileStream);
			}
			outputFile = File.createTempFile("document", "." + outputFormat.getFileExtension());
			convert(inputFile, inputFormat, outputFile, outputFormat);
			InputStream outputFileStream = null;
			try {
				outputFileStream = new FileInputStream(outputFile);
				IOUtils.copy(outputFileStream, outputStream);
			} finally {
				IOUtils.closeQuietly(outputFileStream);
			}
		} catch (IOException ioException) {
			throw new OpenOfficeException("conversion failed", ioException);
		} finally {
			if (inputFile != null) {
				inputFile.delete();
			}
			if (outputFile != null) {
				outputFile.delete();
			}
		}
	}

}