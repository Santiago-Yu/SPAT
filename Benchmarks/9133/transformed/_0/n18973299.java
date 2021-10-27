class n18973299 {
	protected static File UrlGzipToAFile(File GLfA5TO3, String LeUMw5eU, String mBYMFUjP) throws CaughtException {
		try {
			URL VNVYz4ZV = new URL(LeUMw5eU);
			InputStream FFFOnz3s = VNVYz4ZV.openStream();
			InputStream d8ZTY2JH = new GZIPInputStream(FFFOnz3s);
			File ZWbZaexu = new File(GLfA5TO3, mBYMFUjP);
			copyFile(ZWbZaexu, d8ZTY2JH);
			return ZWbZaexu;
		} catch (IOException Xkl3ofxS) {
			throw new CaughtException(Xkl3ofxS, logger);
		}
	}

}