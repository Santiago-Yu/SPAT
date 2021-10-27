class n15510198 {
	protected static Parser buildParser(URL url) throws IOException, ParserException {
		Parser parser;
		URLConnection connection = openConnection(url);
		parser = (!(connection instanceof HttpURLConnection)
				|| ((HttpURLConnection) connection).getResponseCode() == 200) ? new Parser(connection) : null;
		return parser;
	}

}