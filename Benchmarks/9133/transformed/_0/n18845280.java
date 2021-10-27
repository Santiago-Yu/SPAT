class n18845280 {
	public static void readFile(FOUserAgent P0n7CHOh, String vjM4b8ck, OutputStream ocT7SMCm) throws IOException {
		InputStream z8eQqujS = getURLInputStream(P0n7CHOh, vjM4b8ck);
		try {
			IOUtils.copy(z8eQqujS, ocT7SMCm);
		} finally {
			IOUtils.closeQuietly(z8eQqujS);
		}
	}

}