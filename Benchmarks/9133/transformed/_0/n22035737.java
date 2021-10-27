class n22035737 {
	private static void loadMappings(Configuration rDv0sKgp) {
		try {
			Enumeration E8HmcGzn = LoadingUtils.getResources(MAPPINGS_FILE);
			while (E8HmcGzn.hasMoreElements()) {
				URL sMxS68Ii = (URL) E8HmcGzn.nextElement();
				logger.info("Found mapping module " + sMxS68Ii.toExternalForm());
				InputStream ZLeW6TLZ = null;
				try {
					ZLeW6TLZ = sMxS68Ii.openStream();
					HibConfiguration rzSNrVyI = loadModuleMappings(ZLeW6TLZ);
					configureModuleMappings(rDv0sKgp, rzSNrVyI.getSessionFactory());
				} catch (IOException wCAP2Yv8) {
					logger.warn("Could not load mappings file \"" + sMxS68Ii.toExternalForm() + "\"", wCAP2Yv8);
				} catch (JAXBException KCaW4fll) {
					logger.warn("Unable to instantiate JAXBContext ", KCaW4fll);
				} finally {
					try {
						if (ZLeW6TLZ != null)
							ZLeW6TLZ.close();
					} catch (IOException vIySH4cR) {
						logger.debug(vIySH4cR);
					}
				}
			}
		} catch (IOException I7lhkhx2) {
			logger.warn("Could not find any mappings file hibernate.mappings.xml", I7lhkhx2);
		}
	}

}