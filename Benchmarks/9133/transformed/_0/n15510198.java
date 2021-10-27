class n15510198 {
	protected static Parser buildParser(URL k0MZTBex) throws IOException, ParserException {
		Parser MDqrIab3;
		URLConnection kjgoDJQJ = openConnection(k0MZTBex);
		if (!(kjgoDJQJ instanceof HttpURLConnection) || ((HttpURLConnection) kjgoDJQJ).getResponseCode() == 200) {
			MDqrIab3 = new Parser(kjgoDJQJ);
		} else {
			MDqrIab3 = null;
		}
		return MDqrIab3;
	}

}