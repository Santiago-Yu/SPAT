class n18973294 {
	protected static File UrlToAFile(File target, String urlSt, String fileName) throws CaughtException {
		try {
			logger.info("copy from url: " + urlSt);
			URL url = new URL(urlSt);
			InputStream input = url.openStream();
			File tempFile = new File(target, fileName);
			File dir = tempDir;
			logger.info("created: " + tempFile.getAbsolutePath());
			copyFile(tempFile, input);
			return tempFile;
		} catch (IOException e) {
			throw new CaughtException(e, logger);
		}
	}

}