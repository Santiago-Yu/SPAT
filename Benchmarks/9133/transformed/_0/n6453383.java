class n6453383 {
	@Override
	public TDSScene loadScene(URL eVKbO3R1) throws IOException, IncorrectFormatException, ParsingErrorException {
		boolean MFqRpTlk = setBaseURLFromModelURL(eVKbO3R1);
		TDSScene p6lrb1o7 = loadScene(eVKbO3R1.openStream());
		if (MFqRpTlk) {
			popBaseURL();
		}
		return (p6lrb1o7);
	}

}