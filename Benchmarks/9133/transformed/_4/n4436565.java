class n4436565 {
	public static final InputStream getInputStream(final String location) {
		final File f = new File(location);
		if (f.exists()) {
			try {
				return new FileInputStream(f);
			} catch (final FileNotFoundException e) {
				throw new Error(e);
			}
		}
		URL url = Iotil.class.getClassLoader().getResource(location);
		try {
			url = (url == null) ? new URL(location) : url;
			return url.openStream();
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

}