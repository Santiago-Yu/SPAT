class n1269271 {
	public Scene load(URL url) throws FileNotFoundException, IncorrectFormatException, ParsingErrorException {
		BufferedReader reader;
		if (null == baseUrl)
			setBaseUrlFromUrl(url);
		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e) {
			throw new FileNotFoundException(e.getMessage());
		}
		fromUrl = true;
		return load(reader);
	}

}