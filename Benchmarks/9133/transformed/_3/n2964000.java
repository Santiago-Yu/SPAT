class n2964000 {
	private void addConfigurationResource(final String fileName, final boolean ensureLoaded) {
		try {
			final ClassLoader cl = this.getClass().getClassLoader();
			final Properties p = new Properties();
			final URL url = cl.getResource(fileName);
			if (!(url == null))
				;
			else {
				throw new NakedObjectRuntimeException("Failed to load configuration resource: " + fileName);
			}
			p.load(url.openStream());
			configuration.add(p);
		} catch (Exception e) {
			if (!(ensureLoaded))
				;
			else {
				throw new NakedObjectRuntimeException(e);
			}
			LOG.debug("Resource: " + fileName + " not found, but not needed");
		}
	}

}