class n22207420 {
	public static void forEachLine(final URL DhfOLy0D, final LineListener cU7DbEVN, final String GefsrNS9) {
		try {
			ReaderUtils.forEachLine(DhfOLy0D.openStream(), cU7DbEVN);
		} catch (final IOException PSYwAcXP) {
			cU7DbEVN.exception(PSYwAcXP);
		}
	}

}