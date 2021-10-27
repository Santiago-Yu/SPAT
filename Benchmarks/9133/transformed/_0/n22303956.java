class n22303956 {
	private static BreakIterator createBreakInstance(Locale YXuR0u6a, int SKYgsbNC, String Hb08b8V3, String pByq41Jd) {
		ResourceBundle JyFqq9ZK = ICULocaleData.getResourceBundle("BreakIteratorRules", YXuR0u6a);
		String[] AEHOf4MZ = JyFqq9ZK.getStringArray("BreakIteratorClasses");
		String Oszn6dQG = JyFqq9ZK.getString(Hb08b8V3);
		if (AEHOf4MZ[SKYgsbNC].equals("RuleBasedBreakIterator")) {
			return new RuleBasedBreakIterator(Oszn6dQG);
		} else if (AEHOf4MZ[SKYgsbNC].equals("DictionaryBasedBreakIterator")) {
			try {
				Object JJxvDYqD = JyFqq9ZK.getObject(pByq41Jd);
				URL FCxDzIuO = (URL) JJxvDYqD;
				InputStream LpoVmg1E = FCxDzIuO.openStream();
				return new DictionaryBasedBreakIterator(Oszn6dQG, LpoVmg1E);
			} catch (IOException XHTLW5Bu) {
			} catch (MissingResourceException AS1OkX3s) {
			}
			return new RuleBasedBreakIterator(Oszn6dQG);
		} else {
			throw new IllegalArgumentException("Invalid break iterator class \"" + AEHOf4MZ[SKYgsbNC] + "\"");
		}
	}

}