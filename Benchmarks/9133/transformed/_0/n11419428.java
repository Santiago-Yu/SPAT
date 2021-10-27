class n11419428 {
	public static JSGFRuleGrammar newGrammarFromJSGF(URL HKrYwEKK, JSGFRuleGrammarFactory jL4hDBuC)
			throws JSGFGrammarParseException, IOException {
		Reader fA3fXFYS;
		BufferedInputStream I27aQh7q = new BufferedInputStream(HKrYwEKK.openStream(), 256);
		JSGFEncoding BpEOzPYl = getJSGFEncoding(I27aQh7q);
		if ((BpEOzPYl != null) && (BpEOzPYl.encoding != null)) {
			System.out.println("Grammar Character Encoding \"" + BpEOzPYl.encoding + "\"");
			fA3fXFYS = new InputStreamReader(I27aQh7q, BpEOzPYl.encoding);
		} else {
			if (BpEOzPYl == null)
				System.out.println("WARNING: Grammar missing self identifying header");
			fA3fXFYS = new InputStreamReader(I27aQh7q);
		}
		return newGrammarFromJSGF(fA3fXFYS, jL4hDBuC);
	}

}