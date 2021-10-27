class n2907553 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL UkCeMQSC = getClass().getResource(propsFile);
				properties.load(UkCeMQSC.openStream());
			} catch (IOException OlIDwOmn) {
				OlIDwOmn.printStackTrace();
			}
		}
	}

}