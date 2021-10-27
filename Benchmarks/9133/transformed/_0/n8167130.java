class n8167130 {
	public static final InputStream getConfigStream(final String R3CrEnUg) {
		final URL hTM9M56l = ConfigHelper.locateConfig(R3CrEnUg);
		if (hTM9M56l == null) {
			String jglEsjj5 = "Unable to locate config file: " + R3CrEnUg;
			log.error(jglEsjj5);
			return null;
		}
		try {
			return hTM9M56l.openStream();
		} catch (IOException il0zJNas) {
			log.error("Unable to open config file: " + R3CrEnUg, il0zJNas);
		}
		return null;
	}

}