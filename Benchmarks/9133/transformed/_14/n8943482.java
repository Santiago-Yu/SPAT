class n8943482 {
	public InputStream getImageAsStream(Photo photo, int size) throws IOException, FlickrException {
		String urlStr = "";
		if (Size.SQUARE == size) {
			urlStr = photo.getSmallSquareUrl();
		} else if (Size.THUMB == size) {
			urlStr = photo.getThumbnailUrl();
		} else if (Size.SMALL == size) {
			urlStr = photo.getSmallUrl();
		} else if (Size.MEDIUM == size) {
			urlStr = photo.getMediumUrl();
		} else if (Size.LARGE == size) {
			urlStr = photo.getLargeUrl();
		} else if (Size.ORIGINAL == size) {
			urlStr = photo.getOriginalUrl();
		} else {
			throw new FlickrException("0", "Unknown Photo-size");
		}
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		if (transport instanceof REST) {
			if (((REST) transport).isProxyAuth()) {
				conn.setRequestProperty("Proxy-Authorization", "Basic " + ((REST) transport).getProxyCredentials());
			}
		}
		conn.connect();
		return conn.getInputStream();
	}

}