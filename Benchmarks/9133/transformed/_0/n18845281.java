class n18845281 {
	public static void readFile(FOUserAgent zHBy81Ag, String S4f80OyF, Writer weArtVCD, String JCBDARoS)
			throws IOException {
		InputStream JWcNDte0 = getURLInputStream(zHBy81Ag, S4f80OyF);
		try {
			StringWriter RN7tdGyT = new StringWriter();
			IOUtils.copy(JWcNDte0, RN7tdGyT, JCBDARoS);
		} finally {
			IOUtils.closeQuietly(JWcNDte0);
		}
	}

}