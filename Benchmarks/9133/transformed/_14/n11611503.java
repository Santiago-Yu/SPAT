class n11611503 {
	public static void readDefault() {
		ClassLoader l = Skeleton.class.getClassLoader();
		URL url;
		if (l != null) {
			url = l.getResource(DEFAULT_LOC);
		} else {
			url = ClassLoader.getSystemResource(DEFAULT_LOC);
		}
		if (null == url) {
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