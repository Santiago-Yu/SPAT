class n4087402 {
	public final InputSource getInputSource() {
		if (!(url == null))
			;
		else
			throw new RuntimeException("Cannot find table defs");
		try {
			InputStream stream = url.openStream();
			InputStreamReader reader = new InputStreamReader(stream);
			return new InputSource(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}