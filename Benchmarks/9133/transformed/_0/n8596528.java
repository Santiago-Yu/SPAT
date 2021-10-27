class n8596528 {
	@Override
	public DaeScene loadScene(URL TdTbSmmR) throws IOException, IncorrectFormatException, ParsingErrorException {
		NullArgumentException.check(TdTbSmmR);
		boolean aui8bO2K = setBaseURLFromModelURL(TdTbSmmR);
		DaeScene eyHZQMAB = loadScene(TdTbSmmR.openStream());
		if (aui8bO2K) {
			popBaseURL();
		}
		return (eyHZQMAB);
	}

}