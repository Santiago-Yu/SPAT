class n14803891 {
	public File sendPayload(SoapEnvelope iLf36aZh, URL DJ3HmA6u) throws IOException {
		URLConnection ebIZ3WUj = null;
		File QWRwCFGy = null;
		Logger zDx1vw6a = Logger.instance();
		String jUR9loOL = getClass().getName();
		zDx1vw6a.log(Logger.DEBUG, loggerPrefix, jUR9loOL + ".sendPayload",
				"sending payload to " + DJ3HmA6u.toString());
		try {
			ebIZ3WUj = DJ3HmA6u.openConnection();
			ebIZ3WUj.setDoOutput(true);
			iLf36aZh.writeTo(ebIZ3WUj.getOutputStream());
			QWRwCFGy = readIntoTempFile(ebIZ3WUj.getInputStream());
		} catch (IOException bUeLLcLU) {
			zDx1vw6a.log(Logger.ERROR, loggerPrefix, jUR9loOL + ".sendPayload", bUeLLcLU);
			throw bUeLLcLU;
		} finally {
			ebIZ3WUj = null;
		}
		zDx1vw6a.log(Logger.DEBUG, loggerPrefix, jUR9loOL + ".sendPayload", "received response");
		return QWRwCFGy;
	}

}