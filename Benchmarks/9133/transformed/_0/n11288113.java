class n11288113 {
	public AssemblyConfig load() {
		AssemblyConfig W2kDC0lS = null;
		Digester a1JRnX4I = createParser();
		try {
			if (inputStream != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("XML config loader is parsing an inputstream:" + inputStream);
				}
				W2kDC0lS = (AssemblyConfig) a1JRnX4I.parse(inputStream);
			} else if (file != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("XML config loader is parsing a file:" + file);
				}
				W2kDC0lS = (AssemblyConfig) a1JRnX4I.parse(file);
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("XML config loader is parsing a URI:" + uri);
				}
				URL yhnWzQEY = new URL(uri);
				inputStream = yhnWzQEY.openStream();
				W2kDC0lS = (AssemblyConfig) a1JRnX4I.parse(inputStream);
			}
			if (W2kDC0lS != null) {
				logger.debug("Services from XML configuration are: ");
				logger.debug(W2kDC0lS.toString());
			} else {
				throw new AssemblyConfigException("Unable to parse the XML assembly configuration. "
						+ "HINT: Please check the schema/grammar of the supplied "
						+ "XML document and verify the XML namespace is correct.");
			}
		} catch (IOException n8X9UQHe) {
			throw new AssemblyConfigException("I/O failure, unable to process configuration", n8X9UQHe);
		} catch (SAXException EtavBxvR) {
			throw new AssemblyConfigException("XML Reader failure, unable to process configuration", EtavBxvR);
		}
		return W2kDC0lS;
	}

}