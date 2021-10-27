class n4497273 {
	private String fetchLocalPage(String IFTtdCD1) throws IOException {
		final String g0ACK42D = HOST + IFTtdCD1;
		LOG.debug("Fetching local page: " + g0ACK42D);
		URL tNPmAx7k = new URL(g0ACK42D);
		URLConnection qrhTVqn0 = tNPmAx7k.openConnection();
		StringBuilder LB2pHGOY = new StringBuilder();
		BufferedReader GZaex8oG = null;
		try {
			GZaex8oG = new BufferedReader(new InputStreamReader(qrhTVqn0.getInputStream()));
			String BD49xlCc = null;
			while ((BD49xlCc = GZaex8oG.readLine()) != null) {
				LB2pHGOY.append(BD49xlCc).append("\n");
			}
		} finally {
			if (GZaex8oG != null)
				try {
					GZaex8oG.close();
				} catch (IOException y5QePnvP) {
					LOG.error("Could not close reader!", y5QePnvP);
				}
		}
		return LB2pHGOY.toString();
	}

}