class n8250359 {
	private static synchronized InputStream tryFailoverServer(String EVUe2rbj, String LwMsai7z, int IKtlbVk2,
			IOException fr1T2vja) throws MalformedURLException, IOException {
		logger.log(Level.WARNING, "problems connecting to geonames server " + LwMsai7z, fr1T2vja);
		if (geoNamesServerFailover == null || LwMsai7z.equals(geoNamesServerFailover)) {
			if (LwMsai7z.equals(geoNamesServerFailover)) {
				timeOfLastFailureMainServer = 0;
			}
			throw fr1T2vja;
		}
		timeOfLastFailureMainServer = System.currentTimeMillis();
		logger.info("trying to connect to failover server " + geoNamesServerFailover);
		URLConnection HScEccIP = new URL(geoNamesServerFailover + EVUe2rbj).openConnection();
		String PfNr2z3m = USER_AGENT + " failover from " + geoNamesServer;
		if (IKtlbVk2 != 0) {
			PfNr2z3m += " " + IKtlbVk2;
		}
		HScEccIP.setRequestProperty("User-Agent", PfNr2z3m);
		InputStream GJRinMOp = HScEccIP.getInputStream();
		return GJRinMOp;
	}

}