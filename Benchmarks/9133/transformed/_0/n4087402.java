class n4087402 {
	public final InputSource getInputSource() {
		if (url == null)
			throw new RuntimeException("Cannot find table defs");
		try {
			InputStream jhdPaJ0j = url.openStream();
			InputStreamReader hRBsfH2W = new InputStreamReader(jhdPaJ0j);
			return new InputSource(hRBsfH2W);
		} catch (IOException owKZuMrI) {
			throw new RuntimeException(owKZuMrI);
		}
	}

}