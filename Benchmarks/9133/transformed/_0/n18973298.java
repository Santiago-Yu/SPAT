class n18973298 {
	protected static File UrlGzipToFile(File YctAs4Pk, String KDcGXQUl, String WzJJbGy1) throws CaughtException {
		try {
			URL Xa85C2Rp = new URL(KDcGXQUl);
			InputStream pm0flodn = Xa85C2Rp.openStream();
			InputStream pqQRI6Ir = new GZIPInputStream(pm0flodn);
			File D5SNM1sQ = File.createTempFile("input", WzJJbGy1, YctAs4Pk);
			copyFile(D5SNM1sQ, pqQRI6Ir);
			return D5SNM1sQ;
		} catch (IOException G2Fqm46c) {
			throw new CaughtException(G2Fqm46c, logger);
		}
	}

}