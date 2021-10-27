class n14803892 {
	public File getURL(URL yKls0tAe) throws IOException {
		URLConnection MbzTAbEU = null;
		File UxdIt0wn = null;
		Logger rbTtmAZc = Logger.instance();
		String O6aRmakD = getClass().getName();
		rbTtmAZc.log(Logger.DEBUG, loggerPrefix, O6aRmakD + ".getURL", "GET URL " + yKls0tAe.toString());
		try {
			MbzTAbEU = yKls0tAe.openConnection();
			UxdIt0wn = readIntoTempFile(MbzTAbEU.getInputStream());
		} catch (IOException azMrxDop) {
			rbTtmAZc.log(Logger.ERROR, loggerPrefix, O6aRmakD + ".getURL", azMrxDop);
			throw azMrxDop;
		} finally {
			MbzTAbEU = null;
		}
		rbTtmAZc.log(Logger.DEBUG, loggerPrefix, O6aRmakD + ".getURL", "received URL");
		return UxdIt0wn;
	}

}