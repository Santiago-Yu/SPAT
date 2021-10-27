class n21073175 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL Z16sYCpl = getClass().getResource(propsFile);
				properties.load(Z16sYCpl.openStream());
			} catch (IOException i2REjvs9) {
				i2REjvs9.printStackTrace();
			}
		}
	}

}