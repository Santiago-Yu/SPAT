class n10793895 {
	protected void configure() {
		Enumeration<URL> resources = null;
		try {
			resources = classLoader.getResources(resourceName);
		} catch (IOException e) {
			binder().addError(e.getMessage(), e);
			return;
		}
		int resourceCount = 0;
		while (resources.hasMoreElements()) {
			URL url = resources.nextElement();
			log.debug(url + " ...");
			try {
				InputStream stream = url.openStream();
				Properties props = new Properties();
				props.load(stream);
				resourceCount += 1;
				addComponentsFromProperties(props, classLoader);
			} catch (IOException e) {
				binder().addError(e.getMessage(), e);
			}
		}
		log.info("Added components from " + resourceCount + " resources.");
	}

}