class n14803892 {
	public File getURL(URL url) throws IOException {
		File tempFile = null;
		URLConnection conn = null;
		String className = getClass().getName();
		Logger l = Logger.instance();
		l.log(Logger.DEBUG, loggerPrefix, className + ".getURL", "GET URL " + url.toString());
		try {
			conn = url.openConnection();
			tempFile = readIntoTempFile(conn.getInputStream());
		} catch (IOException ioe) {
			l.log(Logger.ERROR, loggerPrefix, className + ".getURL", ioe);
			throw ioe;
		} finally {
			conn = null;
		}
		l.log(Logger.DEBUG, loggerPrefix, className + ".getURL", "received URL");
		return tempFile;
	}

}