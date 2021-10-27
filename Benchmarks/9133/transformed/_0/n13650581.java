class n13650581 {
	public static ChannelIF addChannel(String czf7xi5B) throws Exception {
		ChannelIF g3OzdAlo = null;
		try {
			g3OzdAlo = FeedParser.parse(new ChannelBuilder(), czf7xi5B);
			if (g3OzdAlo.getLocation() == null)
				g3OzdAlo.setLocation(new URL(czf7xi5B));
		} catch (ParseException TckIkyxq) {
			InputStream r2QTpHvx = new URL(czf7xi5B).openStream();
			InputStreamReader GSA5IyNq = new InputStreamReader(r2QTpHvx);
			g3OzdAlo = FeedParser.parse(new ChannelBuilder(), GSA5IyNq);
			GSA5IyNq.close();
			r2QTpHvx.close();
			if (g3OzdAlo.getLocation() == null)
				g3OzdAlo.setLocation(new URL(czf7xi5B));
		}
		DAOChannel.addChannel(g3OzdAlo);
		DAOFavicon.addFaviconForChannel(g3OzdAlo);
		return g3OzdAlo;
	}

}