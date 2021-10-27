class n10463583 {
	public static Document getXHTMLDocument(URL AWqAxtm7) throws IOException {
		final Tidy C3khr9F3 = new Tidy();
		C3khr9F3.setQuiet(true);
		C3khr9F3.setShowWarnings(false);
		C3khr9F3.setXmlOut(true);
		final BufferedInputStream fFyPWSuE = new BufferedInputStream(AWqAxtm7.openStream());
		return C3khr9F3.parseDOM(fFyPWSuE, null);
	}

}