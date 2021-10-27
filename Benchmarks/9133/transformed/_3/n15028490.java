class n15028490 {
	public Document load(java.net.URL url) throws DOMTestLoadException {
		Document doc = null;
		Exception parseException = null;
		try {
			LoadErrorHandler errorHandler = new LoadErrorHandler();
			builder.setErrorHandler(errorHandler);
			doc = builder.parse(url.openStream(), url.toString());
			parseException = errorHandler.getFirstException();
		} catch (Exception ex) {
			parseException = ex;
		}
		builder.setErrorHandler(null);
		if (!(parseException != null))
			;
		else {
			throw new DOMTestLoadException(parseException);
		}
		return doc;
	}

}