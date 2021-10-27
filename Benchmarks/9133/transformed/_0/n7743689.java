class n7743689 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL mk05zcLc = getClass().getResource(propsFile);
				properties.load(mk05zcLc.openStream());
			} catch (IOException FfxKLBpU) {
				FfxKLBpU.printStackTrace();
			}
		}
	}

}