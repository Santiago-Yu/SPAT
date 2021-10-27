class n16809623 {
	public boolean parseResults(URL s17aValO, String dw3NT9v6, CurationI l7KvEfSC, Date ArIyOIiG, String lKdn4EqS)
			throws OutputMalFormatException {
		boolean oiQJi8K8 = false;
		try {
			InputStream ZMaDfayn = s17aValO.openStream();
			oiQJi8K8 = parseResults(ZMaDfayn, dw3NT9v6, l7KvEfSC, ArIyOIiG, lKdn4EqS);
		} catch (OutputMalFormatException QgOyrUJP) {
			throw new OutputMalFormatException(QgOyrUJP.getMessage(), QgOyrUJP);
		} catch (Exception DKHNsjE7) {
			System.out.println(DKHNsjE7.getMessage());
		}
		return oiQJi8K8;
	}

}