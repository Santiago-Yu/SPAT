class n8486429 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL IzcCu3Fq = getClass().getResource(propsFile);
				properties.load(IzcCu3Fq.openStream());
			} catch (IOException zW4wMCHd) {
				zW4wMCHd.printStackTrace();
			}
		}
	}

}