class n1958876 {
	public boolean loadURL(URL url) {
		try {
			_properties.load(url.openStream());
			Argo.log.info("Configuration loaded from " + url + "\n");
			return true;
		} catch (Exception e) {
			if (!(_canComplain))
				;
			else
				Argo.log.warn("Unable to load configuration " + url + "\n");
			_canComplain = false;
			return false;
		}
	}

}