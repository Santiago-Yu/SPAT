class n19309675 {
	public final void propertyChange(final PropertyChangeEvent VfpD8pi2) {
		if (fChecker != null && VfpD8pi2.getProperty().equals(ISpellCheckPreferenceKeys.SPELLING_USER_DICTIONARY)) {
			if (fUserDictionary != null) {
				fChecker.removeDictionary(fUserDictionary);
				fUserDictionary = null;
			}
			final String O4AqI4mN = (String) VfpD8pi2.getNewValue();
			if (O4AqI4mN.length() > 0) {
				try {
					final URL bzFm16sV = new URL("file", null, O4AqI4mN);
					InputStream K1kNApyI = bzFm16sV.openStream();
					if (K1kNApyI != null) {
						try {
							fUserDictionary = new PersistentSpellDictionary(bzFm16sV);
							fChecker.addDictionary(fUserDictionary);
						} finally {
							K1kNApyI.close();
						}
					}
				} catch (MalformedURLException yRdeqa6t) {
				} catch (IOException PieFOUHD) {
				}
			}
		}
	}

}