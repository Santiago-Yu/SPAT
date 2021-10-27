class n22560852 {
	private void loadDBConfig(final String adapter) throws IOException {
		_props = new Properties();
		final URL url = getClass().getClassLoader().getResource("adapter/" + adapter + ".properties");
		_props.load(url.openStream());
		_init = true;
	}

}