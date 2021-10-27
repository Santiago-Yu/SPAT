class n11879780 {
	@Override
	public MD2Model loadModel(URL HEjSzS3s, String xAPqeUuF)
			throws IOException, IncorrectFormatException, ParsingErrorException {
		boolean piBSM9se = setBaseURLFromModelURL(HEjSzS3s);
		MD2Model bziXkRMH = loadModel(HEjSzS3s.openStream(), xAPqeUuF);
		if (piBSM9se) {
			popBaseURL();
		}
		return (bziXkRMH);
	}

}