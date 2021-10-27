class n11477906 {
	private static void loadDefaultSettings(final String qRIvGxrc) {
		InputStream oNSwjcZ0 = null;
		OutputStream jChM78mE = null;
		try {
			oNSwjcZ0 = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(META_INF_DEFAULT_CONFIG_PROPERTIES);
			jChM78mE = new FileOutputStream(qRIvGxrc);
			IOUtils.copy(oNSwjcZ0, jChM78mE);
		} catch (final Exception I8Jbocl3) {
			log.warn("Unable to pull out the default.", I8Jbocl3);
			throw new RuntimeException(I8Jbocl3);
		} finally {
			IOUtils.closeQuietly(oNSwjcZ0);
			IOUtils.closeQuietly(jChM78mE);
		}
	}

}