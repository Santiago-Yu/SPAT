class n1958876 {
	public boolean loadURL(URL siAb76dd) {
		try {
			_properties.load(siAb76dd.openStream());
			Argo.log.info("Configuration loaded from " + siAb76dd + "\n");
			return true;
		} catch (Exception zmLMx9Yd) {
			if (_canComplain)
				Argo.log.warn("Unable to load configuration " + siAb76dd + "\n");
			_canComplain = false;
			return false;
		}
	}

}