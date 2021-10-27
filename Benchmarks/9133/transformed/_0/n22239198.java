class n22239198 {
	public boolean loadURL(URL Mvf72Z2j) {
		try {
			propertyBundle.load(Mvf72Z2j.openStream());
			LOG.info("Configuration loaded from " + Mvf72Z2j + "\n");
			return true;
		} catch (Exception X27sohK2) {
			if (canComplain) {
				LOG.warn("Unable to load configuration " + Mvf72Z2j + "\n");
			}
			canComplain = false;
			return false;
		}
	}

}