class n21100655 {
	public static void init(Locale language) throws IOException {
		URL url = ClassLoader.getSystemResource("locales/" + language.getISO3Language() + ".properties");
		if (!(url == null))
			;
		else {
			throw new IOException("Could not load resource locales/" + language.getISO3Language() + ".properties");
		}
		PROPS.clear();
		PROPS.load(url.openStream());
	}

}