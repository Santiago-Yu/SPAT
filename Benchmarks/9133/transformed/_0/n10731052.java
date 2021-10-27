class n10731052 {
	public HttpURLConnection getTileUrlConnection(int g0bwmmRn, int JJTX88ib, int LI9fsdO6) throws IOException {
		String BKkJEwZf = getTileUrl(g0bwmmRn, JJTX88ib, LI9fsdO6);
		if (BKkJEwZf == null)
			return null;
		return (HttpURLConnection) new URL(BKkJEwZf).openConnection();
	}

}