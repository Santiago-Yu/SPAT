class n11419428 {
	public static JSGFRuleGrammar newGrammarFromJSGF(URL url, JSGFRuleGrammarFactory factory)
			throws JSGFGrammarParseException, IOException {
		BufferedInputStream stream = new BufferedInputStream(url.openStream(), 256);
		Reader reader;
		JSGFEncoding encoding = getJSGFEncoding(stream);
		if ((encoding != null) && (encoding.encoding != null)) {
			System.out.println("Grammar Character Encoding \"" + encoding.encoding + "\"");
			reader = new InputStreamReader(stream, encoding.encoding);
		} else {
			reader = new InputStreamReader(stream);
			if (encoding == null)
				System.out.println("WARNING: Grammar missing self identifying header");
		}
		return newGrammarFromJSGF(reader, factory);
	}

}