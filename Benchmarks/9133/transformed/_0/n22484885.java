class n22484885 {
	private void initClientConfigurationFromURL(String ZKjeCPhK) throws Exception {
		try {
			URL Y0cQGvZh = ProxyURLFactory.createHttpUrl(ZKjeCPhK);
			initClientConfiguration(Y0cQGvZh.openStream());
		} catch (Exception xup8CbAe) {
			throw new Exception("Could not initialize from Client Configuration URL:" + ZKjeCPhK, xup8CbAe);
		}
	}

}