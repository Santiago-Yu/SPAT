class n4778473 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL l3YC9Cv9 = getClass().getResource(propsFile);
				properties.load(l3YC9Cv9.openStream());
			} catch (IOException cLY8U27I) {
				cLY8U27I.printStackTrace();
			}
		}
	}

}