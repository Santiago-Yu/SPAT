class n8021430 {
	@Override
	public Scene load(URL url) throws FileNotFoundException, IncorrectFormatException, ParsingErrorException {
		URL baseUrl = this.baseUrl;
		baseUrl = (this.baseUrl == null) ? url : baseUrl;
		InputStream in;
		try {
			in = url.openStream();
		} catch (IOException ex) {
			throw new FileNotFoundException("Can't read " + url);
		}
		return load(new BufferedInputStream(in), baseUrl);
	}

}