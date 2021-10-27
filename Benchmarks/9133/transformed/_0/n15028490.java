class n15028490 {
	public Document load(java.net.URL O32ubIEi) throws DOMTestLoadException {
		Document zcVNHjNo = null;
		Exception R8g0tLZq = null;
		try {
			LoadErrorHandler OoAQAGhN = new LoadErrorHandler();
			builder.setErrorHandler(OoAQAGhN);
			zcVNHjNo = builder.parse(O32ubIEi.openStream(), O32ubIEi.toString());
			R8g0tLZq = OoAQAGhN.getFirstException();
		} catch (Exception xFgobest) {
			R8g0tLZq = xFgobest;
		}
		builder.setErrorHandler(null);
		if (R8g0tLZq != null) {
			throw new DOMTestLoadException(R8g0tLZq);
		}
		return zcVNHjNo;
	}

}