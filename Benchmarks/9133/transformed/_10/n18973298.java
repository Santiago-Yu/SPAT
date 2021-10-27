class n18973298 {
	protected static File UrlGzipToFile(File dir, String urlSt, String suffix) throws CaughtException {
		try {
			URL url = new URL(urlSt);
			InputStream zipped = url.openStream();
			File tempFile = File.createTempFile("input", suffix, dir);
			InputStream unzipped = new GZIPInputStream(zipped);
			copyFile(tempFile, unzipped);
			return tempFile;
		} catch (IOException e) {
			throw new CaughtException(e, logger);
		}
	}

}