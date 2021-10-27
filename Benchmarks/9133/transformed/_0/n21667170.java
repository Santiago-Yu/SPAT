class n21667170 {
	public static void readDefault() {
		ClassLoader Ia9ABLkI = Skeleton.class.getClassLoader();
		URL V3FpKPDn;
		if (Ia9ABLkI != null) {
			V3FpKPDn = Ia9ABLkI.getResource(DEFAULT_LOC);
		} else {
			V3FpKPDn = ClassLoader.getSystemResource(DEFAULT_LOC);
		}
		if (V3FpKPDn == null) {
			Out.error(ErrorMessages.SKEL_IO_ERROR_DEFAULT);
			throw new GeneratorException();
		}
		try {
			InputStreamReader YONUqu0U = new InputStreamReader(V3FpKPDn.openStream());
			readSkel(new BufferedReader(YONUqu0U));
		} catch (IOException JUZrWTni) {
			Out.error(ErrorMessages.SKEL_IO_ERROR_DEFAULT);
			throw new GeneratorException();
		}
	}

}