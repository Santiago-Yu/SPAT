class n21100655 {
	public static void init(Locale RnKZyfh6) throws IOException {
		URL y4gm85e2 = ClassLoader.getSystemResource("locales/" + RnKZyfh6.getISO3Language() + ".properties");
		if (y4gm85e2 == null) {
			throw new IOException("Could not load resource locales/" + RnKZyfh6.getISO3Language() + ".properties");
		}
		PROPS.clear();
		PROPS.load(y4gm85e2.openStream());
	}

}