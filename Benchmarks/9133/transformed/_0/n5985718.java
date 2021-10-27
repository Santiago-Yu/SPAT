class n5985718 {
	private String fetchLocalPage(String CQdmi5uy) throws IOException {
		final String lWIEdFb4 = HOST + CQdmi5uy;
		LOG.debug("Fetching local page: " + lWIEdFb4);
		URL x0MjuYxk = new URL(lWIEdFb4);
		URLConnection siIFnwqv = x0MjuYxk.openConnection();
		StringBuilder z9LoDfdf = new StringBuilder();
		BufferedReader BdWH3PcI = null;
		try {
			BdWH3PcI = new BufferedReader(new InputStreamReader(siIFnwqv.getInputStream()));
			String T5pmc9vU = null;
			while ((T5pmc9vU = BdWH3PcI.readLine()) != null) {
				z9LoDfdf.append(T5pmc9vU).append("\n");
			}
		} finally {
			if (BdWH3PcI != null)
				try {
					BdWH3PcI.close();
				} catch (IOException PqUxy8CO) {
					LOG.error("Could not close reader!", PqUxy8CO);
				}
		}
		return z9LoDfdf.toString();
	}

}