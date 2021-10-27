class n21182766 {
	public static Properties load(String propsName) {
		URL url = ClassLoader.getSystemResource(propsName);
		Properties props = new Properties();
		try {
			props.load(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

}