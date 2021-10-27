class n14389765 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL SnXhVIiW = getClass().getResource(propsFile);
				properties.load(SnXhVIiW.openStream());
			} catch (IOException MqeC67j8) {
				MqeC67j8.printStackTrace();
			}
		}
	}

}