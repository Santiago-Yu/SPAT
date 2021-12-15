class n22303956 {
	private static BreakIterator createBreakInstance(Locale where, int kind, String rulesName, String dictionaryName) {
		ResourceBundle bundle = ICULocaleData.getResourceBundle("BreakIteratorRules", where);
		String[] classNames = bundle.getStringArray("BreakIteratorClasses");
		String rules = bundle.getString(rulesName);
		if ("RuleBasedBreakIterator".equals(classNames[kind])) {
			return new RuleBasedBreakIterator(rules);
		} else if ("DictionaryBasedBreakIterator".equals(classNames[kind])) {
			try {
				Object t = bundle.getObject(dictionaryName);
				URL url = (URL) t;
				InputStream dictionary = url.openStream();
				return new DictionaryBasedBreakIterator(rules, dictionary);
			} catch (IOException e) {
			} catch (MissingResourceException e) {
			}
			return new RuleBasedBreakIterator(rules);
		} else {
			throw new IllegalArgumentException("Invalid break iterator class \"" + classNames[kind] + "\"");
		}
	}

}