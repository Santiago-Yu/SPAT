class n14803891 {
	public File sendPayload(SoapEnvelope payload, URL url) throws IOException {
		File tempFile = null;
		URLConnection conn = null;
		String className = getClass().getName();
		Logger l = Logger.instance();
		l.log(Logger.DEBUG, loggerPrefix, className + ".sendPayload", "sending payload to " + url.toString());
		try {
			conn = url.openConnection();
			conn.setDoOutput(true);
			payload.writeTo(conn.getOutputStream());
			tempFile = readIntoTempFile(conn.getInputStream());
		} catch (IOException ioe) {
			l.log(Logger.ERROR, loggerPrefix, className + ".sendPayload", ioe);
			throw ioe;
		} finally {
			conn = null;
		}
		l.log(Logger.DEBUG, loggerPrefix, className + ".sendPayload", "received response");
		return tempFile;
	}

}