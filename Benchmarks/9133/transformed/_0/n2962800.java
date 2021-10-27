class n2962800 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL ssZuJgiL = getClass().getResource(propsFile);
				properties.load(ssZuJgiL.openStream());
			} catch (IOException eV73MjPM) {
				eV73MjPM.printStackTrace();
			}
		}
	}

}