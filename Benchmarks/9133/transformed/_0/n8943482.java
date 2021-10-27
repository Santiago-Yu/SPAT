class n8943482 {
	public InputStream getImageAsStream(Photo CaSqjBGh, int ekBHbBxU) throws IOException, FlickrException {
		String ZT5jzNaJ = "";
		if (ekBHbBxU == Size.SQUARE) {
			ZT5jzNaJ = CaSqjBGh.getSmallSquareUrl();
		} else if (ekBHbBxU == Size.THUMB) {
			ZT5jzNaJ = CaSqjBGh.getThumbnailUrl();
		} else if (ekBHbBxU == Size.SMALL) {
			ZT5jzNaJ = CaSqjBGh.getSmallUrl();
		} else if (ekBHbBxU == Size.MEDIUM) {
			ZT5jzNaJ = CaSqjBGh.getMediumUrl();
		} else if (ekBHbBxU == Size.LARGE) {
			ZT5jzNaJ = CaSqjBGh.getLargeUrl();
		} else if (ekBHbBxU == Size.ORIGINAL) {
			ZT5jzNaJ = CaSqjBGh.getOriginalUrl();
		} else {
			throw new FlickrException("0", "Unknown Photo-size");
		}
		URL BGPruUt7 = new URL(ZT5jzNaJ);
		HttpURLConnection JWYiNwkF = (HttpURLConnection) BGPruUt7.openConnection();
		if (transport instanceof REST) {
			if (((REST) transport).isProxyAuth()) {
				JWYiNwkF.setRequestProperty("Proxy-Authorization", "Basic " + ((REST) transport).getProxyCredentials());
			}
		}
		JWYiNwkF.connect();
		return JWYiNwkF.getInputStream();
	}

}