class n7942254 {
	public static Properties load(String classPath) throws IOException {
		AssertUtility.notNullAndNotSpace(classPath);
		URL url = ClassLoader.getSystemResource(classPath);
		Properties props = new Properties();
		props.load(url.openStream());
		return props;
	}

}