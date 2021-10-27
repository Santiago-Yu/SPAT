class n4574772 {
	public static boolean init(String language) {
		strings = new Properties();
		URL url = S.class.getResource("strings_" + language + ".txt");
		;
		try {
			strings.load(url.openStream());
		} catch (Exception e) {
			String def = "en";
			if (language.equals(def))
				return false;
			return init(def);
		}
		return true;
	}

}