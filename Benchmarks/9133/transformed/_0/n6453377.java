class n6453377 {
	@Override
	public TDSModel loadModel(URL TPLpNkld, String hGORKaXj)
			throws IOException, IncorrectFormatException, ParsingErrorException {
		boolean t0HVrVvW = setBaseURLFromModelURL(TPLpNkld);
		TDSModel joxOTi0p = loadModel(TPLpNkld.openStream(), hGORKaXj);
		if (t0HVrVvW) {
			popBaseURL();
		}
		return (joxOTi0p);
	}

}