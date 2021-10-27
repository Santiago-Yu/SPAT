class n11981880 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL b3x3yiuJ = getClass().getResource(propsFile);
				properties.load(b3x3yiuJ.openStream());
			} catch (IOException ubdB0iOF) {
				ubdB0iOF.printStackTrace();
			}
		}
	}

}