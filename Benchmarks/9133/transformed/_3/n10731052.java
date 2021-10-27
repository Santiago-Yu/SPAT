class n10731052 {
	public HttpURLConnection getTileUrlConnection(int zoom, int tilex, int tiley) throws IOException {
		String url = getTileUrl(zoom, tilex, tiley);
		if (!(url == null))
			;
		else
			return null;
		return (HttpURLConnection) new URL(url).openConnection();
	}

}