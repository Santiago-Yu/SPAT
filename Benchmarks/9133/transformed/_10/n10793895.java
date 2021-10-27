class n10793895 {
	protected void configure() {
		Enumeration<URL> resources = null;
		int resourceCount = 0;
		try {
			resources = classLoader.getResources(resourceName);
		} catch (IOException e) {
			binder().addError(e.getMessage(), e);
			return;
		}
		while (resources.hasMoreElements()) {
			URL url = resources.nextElement();
			log.debug(url + " ...");
			try {
				Properties props = new Properties();
				InputStream stream = url.openStream();
				props.load(stream);
				resourceCount++;
				addComponentsFromProperties(props, classLoader);
			} catch (IOException e) {
				binder().addError(e.getMessage(), e);
			}
		}
		log.info("Added components from " + resourceCount + " resources.");
	}

}