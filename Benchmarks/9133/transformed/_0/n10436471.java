class n10436471 {
	@Override
	public Cal3dModel loadModel(URL xm8fn4jm, String d2s5qIPr)
			throws IOException, IncorrectFormatException, ParsingErrorException {
		boolean gpqrGglz = setBaseURLFromModelURL(xm8fn4jm);
		Cal3dModel MwTfRR5X = new Cal3dModel(getFlags());
		loadCal3dModel(getBaseURL(), xm8fn4jm.toExternalForm(), new InputStreamReader(xm8fn4jm.openStream()), MwTfRR5X);
		if (gpqrGglz) {
			popBaseURL();
		}
		return (MwTfRR5X);
	}

}