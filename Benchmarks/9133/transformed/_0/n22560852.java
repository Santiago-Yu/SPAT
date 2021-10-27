class n22560852 {
	private void loadDBConfig(final String xez8X4mM) throws IOException {
		final URL I4wlTjND = getClass().getClassLoader().getResource("adapter/" + xez8X4mM + ".properties");
		_props = new Properties();
		_props.load(I4wlTjND.openStream());
		_init = true;
	}

}