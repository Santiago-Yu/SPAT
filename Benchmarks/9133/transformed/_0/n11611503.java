class n11611503 {
	public static void readDefault() {
		ClassLoader gktFkmjh = Skeleton.class.getClassLoader();
		URL lj2Tvsla;
		if (gktFkmjh != null) {
			lj2Tvsla = gktFkmjh.getResource(DEFAULT_LOC);
		} else {
			lj2Tvsla = ClassLoader.getSystemResource(DEFAULT_LOC);
		}
		if (lj2Tvsla == null) {
			Out.error(ErrorMessages.SKEL_IO_ERROR_DEFAULT);
			throw new GeneratorException();
		}
		try {
			InputStreamReader y01YaM9S = new InputStreamReader(lj2Tvsla.openStream());
			readSkel(new BufferedReader(y01YaM9S));
		} catch (IOException a4XXK3wN) {
			Out.error(ErrorMessages.SKEL_IO_ERROR_DEFAULT);
			throw new GeneratorException();
		}
	}

}