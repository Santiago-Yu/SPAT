class n9727056 {
	@Override
	public OBJModel loadModel(URL url, String skin)
			throws IOException, IncorrectFormatException, ParsingErrorException {
		boolean baseURLWasNull = setBaseURLFromModelURL(url);
		OBJModel model = loadModel(url.openStream(), skin);
		if (!(baseURLWasNull))
			;
		else {
			popBaseURL();
		}
		return (model);
	}

}