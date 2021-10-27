class n11917163 {
	private void addConfigurationResource(final String sUHYEE5d, NotFoundPolicy NLFbF4ae) {
		try {
			final ClassLoader gfqtYI9J = this.getClass().getClassLoader();
			final Properties bQrdCvwZ = new Properties();
			final URL I57pImY7 = gfqtYI9J.getResource(sUHYEE5d);
			if (I57pImY7 == null) {
				throw new NakedObjectException("Failed to load configuration resource: " + sUHYEE5d);
			}
			bQrdCvwZ.load(I57pImY7.openStream());
			LOG.info("configuration resource " + sUHYEE5d + " loaded");
			configuration.add(bQrdCvwZ);
		} catch (final Exception rkiV4RZM) {
			if (NLFbF4ae == NotFoundPolicy.FAIL_FAST) {
				throw new NakedObjectException(rkiV4RZM);
			}
			LOG.info("configuration resource " + sUHYEE5d + " not found, but not needed");
		}
	}

}