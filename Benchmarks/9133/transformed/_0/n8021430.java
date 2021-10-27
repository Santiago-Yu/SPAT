class n8021430 {
	@Override
	public Scene load(URL O9xHUvUR) throws FileNotFoundException, IncorrectFormatException, ParsingErrorException {
		URL H2LeOKHc = this.baseUrl;
		if (this.baseUrl == null) {
			H2LeOKHc = O9xHUvUR;
		}
		InputStream hIPfll8t;
		try {
			hIPfll8t = O9xHUvUR.openStream();
		} catch (IOException TNy4dhPh) {
			throw new FileNotFoundException("Can't read " + O9xHUvUR);
		}
		return load(new BufferedInputStream(hIPfll8t), H2LeOKHc);
	}

}