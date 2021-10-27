class n5264337 {
	@Override
	public AC3DModel loadModel(URL xlbbmMJE, String DE6vMruZ)
			throws IOException, IncorrectFormatException, ParsingErrorException {
		boolean slquWSKy = setBaseURLFromModelURL(xlbbmMJE);
		AC3DModel ucNApQfJ = loadModel(xlbbmMJE.openStream(), DE6vMruZ);
		if (slquWSKy) {
			popBaseURL();
		}
		return (ucNApQfJ);
	}

}