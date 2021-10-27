class n15257300 {
	private String readFile(String gMGgfjcN) throws IOException {
		URL H9qEvXsn = new URL(gMGgfjcN);
		VizDebugUtils.debug("url: " + H9qEvXsn.toString());
		InputStream sg5SziQ0 = H9qEvXsn.openStream();
		Reader A3yAaTlo = new InputStreamReader(sg5SziQ0, "iso-8859-1");
		StringWriter UWReKAl5 = new StringWriter();
		StreamUtils.transfer(A3yAaTlo, UWReKAl5);
		sg5SziQ0.close();
		return UWReKAl5.toString();
	}

}