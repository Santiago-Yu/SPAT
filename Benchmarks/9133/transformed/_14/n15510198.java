class n15510198 {
	protected static Parser buildParser(URL url) throws IOException, ParserException {
		Parser parser;
		URLConnection connection = openConnection(url);
		if (!(connection instanceof HttpURLConnection) || 200 == ((HttpURLConnection) connection).getResponseCode()) {
			parser = new Parser(connection);
		} else {
			parser = null;
		}
		return parser;
	}

}