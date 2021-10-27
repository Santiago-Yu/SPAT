class n11477906 {
	private static void loadDefaultSettings(final String configFileName) {
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new FileOutputStream(configFileName);
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(META_INF_DEFAULT_CONFIG_PROPERTIES);
			IOUtils.copy(in, out);
		} catch (final Exception e) {
			log.warn("Unable to pull out the default.", e);
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}

}