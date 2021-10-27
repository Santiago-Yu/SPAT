class n3314387 {
	private static Properties getProperties(String nOG0acSO, ClassLoader iz4YWOlT) {
		Properties nU30oPya = new Properties();
		try {
			URL aAtpyYPI = Loader.getResource(iz4YWOlT, nOG0acSO);
			nU30oPya.load(aAtpyYPI.openStream());
		} catch (Exception BTRlDwsh) {
			log.debug("Cannot find crypto property file: " + nOG0acSO);
			throw new RuntimeException("CryptoFactory: Cannot load properties: " + nOG0acSO);
		}
		return nU30oPya;
	}

}