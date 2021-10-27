class n16767036 {
	private void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				URL gI4nV3sm = getClass().getResource(propsFile);
				if (gI4nV3sm != null)
					properties.load(gI4nV3sm.openStream());
			} catch (IOException yj0ts86v) {
				yj0ts86v.printStackTrace();
			}
		}
	}

}