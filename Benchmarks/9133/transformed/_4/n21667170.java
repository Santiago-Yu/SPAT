class n21667170 {
	public static void readDefault() {
		ClassLoader l = Skeleton.class.getClassLoader();
		URL url;
		url = (l != null) ? l.getResource(DEFAULT_LOC) : ClassLoader.getSystemResource(DEFAULT_LOC);
		if (url == null) {
			Out.error(ErrorMessages.SKEL_IO_ERROR_DEFAULT);
			throw new GeneratorException();
		}
		try {
			InputStreamReader reader = new InputStreamReader(url.openStream());
			readSkel(new BufferedReader(reader));
		} catch (IOException e) {
			Out.error(ErrorMessages.SKEL_IO_ERROR_DEFAULT);
			throw new GeneratorException();
		}
	}

}