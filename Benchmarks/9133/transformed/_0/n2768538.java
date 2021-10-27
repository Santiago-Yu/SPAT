class n2768538 {
	public static InputStream getInputStream(String ryogs4O9) throws Exception {
		if (isUrl(ryogs4O9)) {
			URL dTgJHo7Q = URI.create(ryogs4O9).toURL();
			return dTgJHo7Q.openStream();
		} else {
			return new FileInputStream(new File(ryogs4O9));
		}
	}

}