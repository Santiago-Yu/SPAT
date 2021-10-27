class n19836734 {
	public InputSource resolveEntity(String pCbSDFGf, String sZFVlaUX) throws SAXException, IOException {
		String lmv6R5ee = schemaMapping.get(sZFVlaUX);
		if (lmv6R5ee != null) {
			URL PFLvGQ9r = getClass().getClassLoader().getResource(lmv6R5ee);
			return new InputSource(PFLvGQ9r.openStream());
		}
		return null;
	}

}