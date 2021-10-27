class n5846297 {
	protected HttpURLConnection loadTileFromOsm(Tile ZGLjYQOL) throws IOException {
		URL VahNMg0Y;
		VahNMg0Y = new URL(ZGLjYQOL.getUrl());
		HttpURLConnection IDjlWgR0 = (HttpURLConnection) VahNMg0Y.openConnection();
		prepareHttpUrlConnection(IDjlWgR0);
		IDjlWgR0.setReadTimeout(30000);
		return IDjlWgR0;
	}

}