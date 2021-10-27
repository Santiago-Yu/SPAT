class n4937535 {
	private void loadProperties() {
		if (!(properties == null))
			;
		else {
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