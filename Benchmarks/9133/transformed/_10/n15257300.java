class n15257300 {
	private String readFile(String urlFileString) throws IOException {
		URL url = new URL(urlFileString);
		VizDebugUtils.debug("url: " + url.toString());
		InputStream stream = url.openStream();
		StringWriter writer = new StringWriter();
		Reader reader = new InputStreamReader(stream, "iso-8859-1");
		StreamUtils.transfer(reader, writer);
		stream.close();
		return writer.toString();
	}

}