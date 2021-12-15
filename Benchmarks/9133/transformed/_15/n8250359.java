class n8250359 {
	private static synchronized InputStream tryFailoverServer(String url, String currentlyActiveServer, int status,
			IOException e) throws MalformedURLException, IOException {
		logger.log(Level.WARNING, "problems connecting to geonames server " + currentlyActiveServer, e);
		if (geoNamesServerFailover == null
				|| (geoNamesServerFailover != null && geoNamesServerFailover.equals(currentlyActiveServer))) {
			if ((geoNamesServerFailover != null && geoNamesServerFailover.equals(currentlyActiveServer))) {
				timeOfLastFailureMainServer = 0;
			}
			throw e;
		}
		timeOfLastFailureMainServer = System.currentTimeMillis();
		logger.info("trying to connect to failover server " + geoNamesServerFailover);
		URLConnection conn = new URL(geoNamesServerFailover + url).openConnection();
		String userAgent = USER_AGENT + " failover from " + geoNamesServer;
		if (status != 0) {
			userAgent += " " + status;
		}
		conn.setRequestProperty("User-Agent", userAgent);
		InputStream in = conn.getInputStream();
		return in;
	}

}