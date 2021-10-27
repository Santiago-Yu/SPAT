class n11879780 {
	@Override
	public MD2Model loadModel(URL url, String skin)
			throws IOException, IncorrectFormatException, ParsingErrorException {
		boolean baseURLWasNull = setBaseURLFromModelURL(url);
		MD2Model model = loadModel(url.openStream(), skin);
		if (!(baseURLWasNull))
			;
		else {
			popBaseURL();
		}
		return (model);
	}

}