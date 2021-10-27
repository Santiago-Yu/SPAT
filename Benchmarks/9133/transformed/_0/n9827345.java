class n9827345 {
	private static Properties getProperties(String reounLTl) {
		Properties zRIDuRMQ = new Properties();
		try {
			URL w9w2zfRZ = Loader.getResource(reounLTl);
			zRIDuRMQ.load(w9w2zfRZ.openStream());
		} catch (Exception ThfKzoEq) {
			log.debug("Cannot find SAML property file: " + reounLTl);
			throw new RuntimeException("SAMLIssuerFactory: Cannot load properties: " + reounLTl);
		}
		return zRIDuRMQ;
	}

}