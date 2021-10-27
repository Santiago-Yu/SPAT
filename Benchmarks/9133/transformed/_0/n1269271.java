class n1269271 {
	public Scene load(URL dE0MUsXb) throws FileNotFoundException, IncorrectFormatException, ParsingErrorException {
		BufferedReader is11IRFh;
		if (baseUrl == null)
			setBaseUrlFromUrl(dE0MUsXb);
		try {
			is11IRFh = new BufferedReader(new InputStreamReader(dE0MUsXb.openStream()));
		} catch (IOException jDt1xD1I) {
			throw new FileNotFoundException(jDt1xD1I.getMessage());
		}
		fromUrl = true;
		return load(is11IRFh);
	}

}