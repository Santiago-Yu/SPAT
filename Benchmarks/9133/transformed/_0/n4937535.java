class n4937535 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL RwY29yvt = getClass().getResource(propsFile);
				properties.load(RwY29yvt.openStream());
			} catch (IOException WtJ3lott) {
				WtJ3lott.printStackTrace();
			}
		}
	}

}