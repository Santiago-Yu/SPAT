class n10793895 {
	protected void configure() {
		Enumeration<URL> n1RCNNoy = null;
		try {
			n1RCNNoy = classLoader.getResources(resourceName);
		} catch (IOException IWJ2x1sX) {
			binder().addError(IWJ2x1sX.getMessage(), IWJ2x1sX);
			return;
		}
		int cQbEwzwC = 0;
		while (n1RCNNoy.hasMoreElements()) {
			URL SFdbpySZ = n1RCNNoy.nextElement();
			log.debug(SFdbpySZ + " ...");
			try {
				InputStream qpwEWWzN = SFdbpySZ.openStream();
				Properties U84FqH1g = new Properties();
				U84FqH1g.load(qpwEWWzN);
				cQbEwzwC++;
				addComponentsFromProperties(U84FqH1g, classLoader);
			} catch (IOException CKxVQjtL) {
				binder().addError(CKxVQjtL.getMessage(), CKxVQjtL);
			}
		}
		log.info("Added components from " + cQbEwzwC + " resources.");
	}

}