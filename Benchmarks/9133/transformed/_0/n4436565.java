class n4436565 {
	public static final InputStream getInputStream(final String JJgn7yIA) {
		final File I6wDauAh = new File(JJgn7yIA);
		if (I6wDauAh.exists()) {
			try {
				return new FileInputStream(I6wDauAh);
			} catch (final FileNotFoundException Hf18CFky) {
				throw new Error(Hf18CFky);
			}
		}
		URL DHVeKDgr = Iotil.class.getClassLoader().getResource(JJgn7yIA);
		try {
			if (DHVeKDgr == null) {
				DHVeKDgr = new URL(JJgn7yIA);
			}
			return DHVeKDgr.openStream();
		} catch (final IOException GWXERdlb) {
			throw new RuntimeException(GWXERdlb);
		}
	}

}