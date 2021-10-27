class n9727056 {
	@Override
	public OBJModel loadModel(URL ifCAmwS6, String acjjZkPn)
			throws IOException, IncorrectFormatException, ParsingErrorException {
		boolean EHAnhyWp = setBaseURLFromModelURL(ifCAmwS6);
		OBJModel vggyWvcW = loadModel(ifCAmwS6.openStream(), acjjZkPn);
		if (EHAnhyWp) {
			popBaseURL();
		}
		return (vggyWvcW);
	}

}