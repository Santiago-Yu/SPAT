class n2057012 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL YsDrzGtR = getClass().getResource(propsFile);
				properties.load(YsDrzGtR.openStream());
			} catch (IOException FpXRoEIY) {
				FpXRoEIY.printStackTrace();
			}
		}
	}

}