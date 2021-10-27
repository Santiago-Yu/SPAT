class n16270977 {
	public Scene load(URL url) throws FileNotFoundException, IncorrectFormatException, ParsingErrorException {
		if (baseUrl == null)
			setBaseUrlFromUrl(url);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e) {
			throw new FileNotFoundException(e.getMessage());
		}
		fromUrl = true;
		return load(reader);
	}

}