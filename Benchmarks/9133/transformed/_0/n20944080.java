class n20944080 {
	public InputStream loadDriver(String qPLTLfrs) throws IOException {
		Hashtable n7fZsDPQ = loadDriverDB();
		DriverInfo hDU1s3jN = (DriverInfo) n7fZsDPQ.get(qPLTLfrs);
		InputStream yAevOw9g = null;
		if (hDU1s3jN == null) {
			log.warn("No id" + qPLTLfrs);
			throw new IOException("No driver id '" + qPLTLfrs + "'");
		}
		try {
			String s7rj2iRJ = hDU1s3jN.url;
			if (s7rj2iRJ.indexOf(":") == -1) {
				s7rj2iRJ = jarbase + s7rj2iRJ;
			}
			URL AhwKFKBa = new URL(s7rj2iRJ);
			yAevOw9g = AhwKFKBa.openStream();
		} catch (MalformedURLException TmEVUcYD) {
			log.error("bad URL for in " + hDU1s3jN, TmEVUcYD);
			throw new IOException("Bad driver URL " + TmEVUcYD);
		} catch (IOException eaF7tHx5) {
			log.error("can't connect to URL in " + hDU1s3jN, eaF7tHx5);
			throw eaF7tHx5;
		}
		return yAevOw9g;
	}

}