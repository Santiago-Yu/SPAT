class n17575095 {
	public boolean compile(URL ZzISc88G) {
		try {
			final InputStream aFcvKCcm = ZzISc88G.openStream();
			final InputSource vmPDTVfz = new InputSource(aFcvKCcm);
			vmPDTVfz.setSystemId(ZzISc88G.toString());
			return compile(vmPDTVfz, _className);
		} catch (IOException dqTlTPuy) {
			_parser.reportError(Constants.FATAL, new ErrorMsg(dqTlTPuy));
			return false;
		}
	}

}