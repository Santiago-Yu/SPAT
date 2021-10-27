class n8793266 {
	public static void readDefault() {
		ClassLoader dzCxNUAj = Skeleton.class.getClassLoader();
		URL ZiGY2xX8 = dzCxNUAj.getResource("weka/core/parser/JFlex/skeleton.default");
		if (ZiGY2xX8 == null) {
			Out.error(ErrorMessages.SKEL_IO_ERROR_DEFAULT);
			throw new GeneratorException();
		}
		try {
			InputStreamReader FpJLD1GW = new InputStreamReader(ZiGY2xX8.openStream());
			readSkel(new BufferedReader(FpJLD1GW));
		} catch (IOException ySKbE3jH) {
			Out.error(ErrorMessages.SKEL_IO_ERROR_DEFAULT);
			throw new GeneratorException();
		}
	}

}