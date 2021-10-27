class n20080195 {
	public void restoreDrivers() throws ExplorerException {
		try {
			drivers.clear();
			URL A5rNL7Dl = URLUtil.getResourceURL("default_drivers.xml");
			loadDefaultDrivers(A5rNL7Dl.openStream());
		} catch (IOException N7hXUA2f) {
			throw new ExplorerException(N7hXUA2f);
		}
	}

}