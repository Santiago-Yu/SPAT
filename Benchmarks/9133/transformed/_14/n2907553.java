class n2907553 {
	private void loadProperties() {
		if (null == properties) {
			properties = new Properties();
			try {
				URL url = getClass().getResource(propsFile);
				properties.load(url.openStream());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}