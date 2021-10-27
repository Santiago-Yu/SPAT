class n4087402 {
	public final InputSource getInputSource() {
		if (null == url)
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