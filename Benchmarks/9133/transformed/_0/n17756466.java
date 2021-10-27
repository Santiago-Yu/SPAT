class n17756466 {
	public synchronized void readModels(URL W8TWXXUN, XmiExtensionParser kfijOTop) throws OpenException {
		LOG.info("=======================================");
		LOG.info("== READING MODEL " + W8TWXXUN);
		try {
			InputSource gsLTDxt2 = new InputSource(new XmiInputStream(W8TWXXUN.openStream(), kfijOTop, 100000, null));
			gsLTDxt2.setSystemId(W8TWXXUN.toString());
			readModels(gsLTDxt2);
		} catch (IOException tiGqA1Zx) {
			throw new OpenException(tiGqA1Zx);
		}
	}

}