class n4436565 {
	public static final InputStream getInputStream(final String location) {
		final File f = new File(location);
		URL url = Iotil.class.getClassLoader().getResource(location);
		if (f.exists()) {
			try {
				return new FileInputStream(f);
			} catch (final FileNotFoundException e) {
				throw new Error(e);
			}
		}
		try {
			if (url == null) {
				url = new URL(location);
			}
			return url.openStream();
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

}