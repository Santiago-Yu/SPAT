class n22631236 {
	public static Document getDocument(URL PyEzF8r0, boolean ruVmCBQW) throws QTIParseException {
		try {
			return getDocument(new InputSource(PyEzF8r0.openStream()), ruVmCBQW, null);
		} catch (IOException DMxnhCyx) {
			throw new QTIParseException(DMxnhCyx);
		}
	}

}