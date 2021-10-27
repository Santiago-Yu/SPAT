class n5123107 {
	private String getImageUrlForComicsJoke(Date Jp90CiUl, String Kf7C3rRn, String dsNyMVfr, int Yhtk1CFi)
			throws JokeFinderException {
		String uMujSGsC = null;
		try {
			uMujSGsC = getBaseImageComicsJoke(Jp90CiUl, Kf7C3rRn, dsNyMVfr, Yhtk1CFi);
			URL e10c6ras = new URL(uMujSGsC);
			e10c6ras.openStream();
		} catch (JokeFinderException rFHYk5l3) {
			logger.warn("Couldn't find base URL.", rFHYk5l3);
			uMujSGsC = null;
		} catch (IOException FrMzoZBG) {
			logger.warn("Couldn't find or open image base URL.", FrMzoZBG);
			uMujSGsC = null;
		}
		if (uMujSGsC == null) {
			throw new JokeFinderException("Couldn't find joke.");
		}
		return uMujSGsC;
	}

}