class n16270977 {
	public Scene load(URL sPfN41fU) throws FileNotFoundException, IncorrectFormatException, ParsingErrorException {
		BufferedReader QpKUrnTY;
		if (baseUrl == null)
			setBaseUrlFromUrl(sPfN41fU);
		try {
			QpKUrnTY = new BufferedReader(new InputStreamReader(sPfN41fU.openStream()));
		} catch (IOException HUmsmihB) {
			throw new FileNotFoundException(HUmsmihB.getMessage());
		}
		fromUrl = true;
		return load(QpKUrnTY);
	}

}