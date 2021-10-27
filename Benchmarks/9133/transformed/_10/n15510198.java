class n15510198 {
	protected static Parser buildParser(URL url) throws IOException, ParserException {
		URLConnection connection = openConnection(url);
		Parser parser;
		if (!(connection instanceof HttpURLConnection) || ((HttpURLConnection) connection).getResponseCode() == 200) {
			parser = new Parser(connection);
		} else {
			parser = null;
		}
		return parser;
	}

}