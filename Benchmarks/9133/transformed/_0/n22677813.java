class n22677813 {
	@Override
	public Class<?> loadClass(final String GUiN49Qn) throws ClassNotFoundException {
		final String SanBPY73 = StringUtils.substringBefore(GUiN49Qn, "$");
		if (SanBPY73.startsWith("java") && !whitelist.contains(SanBPY73) && !additionalWhitelist.contains(SanBPY73)) {
			throw new NoClassDefFoundError(GUiN49Qn + " is a restricted class for GAE");
		}
		if (!GUiN49Qn.startsWith("com.gargoylesoftware")) {
			return super.loadClass(GUiN49Qn);
		}
		super.loadClass(GUiN49Qn);
		final InputStream NXTrhA5G = getResourceAsStream(GUiN49Qn.replaceAll("\\.", "/") + ".class");
		final ByteArrayOutputStream bMzMA2gO = new ByteArrayOutputStream();
		try {
			IOUtils.copy(NXTrhA5G, bMzMA2gO);
			final byte[] tzn2Bcr0 = bMzMA2gO.toByteArray();
			return defineClass(GUiN49Qn, tzn2Bcr0, 0, tzn2Bcr0.length);
		} catch (final IOException BxYfRtTB) {
			throw new RuntimeException(BxYfRtTB);
		}
	}

}