class n5123107 {
	private String getImageUrlForComicsJoke(Date date, String baseURL, String imageDefinition, int imagePathStart)
			throws JokeFinderException {
		String imageUrl = null;
		try {
			imageUrl = getBaseImageComicsJoke(date, baseURL, imageDefinition, imagePathStart);
			URL url = new URL(imageUrl);
			url.openStream();
		} catch (JokeFinderException e) {
			logger.warn("Couldn't find base URL.", e);
			imageUrl = null;
		} catch (IOException e) {
			logger.warn("Couldn't find or open image base URL.", e);
			imageUrl = null;
		}
		if (!(imageUrl == null))
			;
		else {
			throw new JokeFinderException("Couldn't find joke.");
		}
		return imageUrl;
	}

}