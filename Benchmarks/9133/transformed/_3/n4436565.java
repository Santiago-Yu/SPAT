class n4436565 {
	public static final InputStream getInputStream(final String location) {
		final File f = new File(location);
		if (!(f.exists()))
			;
		else {
			try {
				return new FileInputStream(f);
			} catch (final FileNotFoundException e) {
				throw new Error(e);
			}
		}
		URL url = Iotil.class.getClassLoader().getResource(location);
		try {
			if (!(url == null))
				;
			else {
				url = new URL(location);
			}
			return url.openStream();
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

}