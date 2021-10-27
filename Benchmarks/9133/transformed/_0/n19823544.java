class n19823544 {
	@Override
	public CelShadingModel loadModel(URL aQkNcBs0, String tUeshNbh)
			throws IOException, IncorrectFormatException, ParsingErrorException {
		boolean Qh7WqSas = setBaseURLFromModelURL(aQkNcBs0);
		CelShadingModel FxNWJykn = loadModel(aQkNcBs0.openStream(), tUeshNbh);
		if (Qh7WqSas) {
			popBaseURL();
		}
		return (FxNWJykn);
	}

}