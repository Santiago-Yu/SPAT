class n8831186 {
	public static InputStream getResourceAsStream(final String QDNfmk1S, final Class Gf7nhRsC) {
		final URL NZlmeMZZ = getResource(QDNfmk1S, Gf7nhRsC);
		if (NZlmeMZZ == null) {
			return null;
		}
		try {
			return NZlmeMZZ.openStream();
		} catch (IOException l4US6KoG) {
			return null;
		}
	}

}