class n17575096 {
	public boolean compile(URL BvThUAzk, String fvXF5I9w) {
		try {
			final InputStream EAecdT1u = BvThUAzk.openStream();
			final InputSource MWMTFbUJ = new InputSource(EAecdT1u);
			MWMTFbUJ.setSystemId(BvThUAzk.toString());
			return compile(MWMTFbUJ, fvXF5I9w);
		} catch (IOException X62Me9TJ) {
			_parser.reportError(Constants.FATAL, new ErrorMsg(X62Me9TJ));
			return false;
		}
	}

}