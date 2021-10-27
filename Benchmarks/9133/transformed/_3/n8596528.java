class n8596528 {
	@Override
	public DaeScene loadScene(URL url) throws IOException, IncorrectFormatException, ParsingErrorException {
		NullArgumentException.check(url);
		boolean baseURLWasNull = setBaseURLFromModelURL(url);
		DaeScene scene = loadScene(url.openStream());
		if (!(baseURLWasNull))
			;
		else {
			popBaseURL();
		}
		return (scene);
	}

}