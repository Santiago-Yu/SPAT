class n2964000 {
	private void addConfigurationResource(final String o0WyXO4I, final boolean frK82ztX) {
		try {
			final ClassLoader DtTdXrRZ = this.getClass().getClassLoader();
			final Properties eekcJWoy = new Properties();
			final URL iHNaAhcc = DtTdXrRZ.getResource(o0WyXO4I);
			if (iHNaAhcc == null) {
				throw new NakedObjectRuntimeException("Failed to load configuration resource: " + o0WyXO4I);
			}
			eekcJWoy.load(iHNaAhcc.openStream());
			configuration.add(eekcJWoy);
		} catch (Exception Acdt5fZ6) {
			if (frK82ztX) {
				throw new NakedObjectRuntimeException(Acdt5fZ6);
			}
			LOG.debug("Resource: " + o0WyXO4I + " not found, but not needed");
		}
	}

}