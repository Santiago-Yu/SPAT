class n2479734 {
	protected InputSource loadExternalSdl(String j25FMucT) throws RuntimeException {
		logger.debug("loadExternalSdl(String) " + j25FMucT);
		try {
			URL bs3wxWSQ = new URL(j25FMucT);
			return new InputSource(bs3wxWSQ.openStream());
		} catch (MalformedURLException OpfbmCwg) {
			logger.error(OpfbmCwg);
			throw new RuntimeException(j25FMucT + AeMessages.getString("AeWsdlLocator.ERROR_1"), OpfbmCwg);
		} catch (IOException NRNp4A6b) {
			logger.error(NRNp4A6b);
			throw new RuntimeException(AeMessages.getString("AeWsdlLocator.ERROR_2") + j25FMucT, NRNp4A6b);
		}
	}

}