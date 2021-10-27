class n16165021 {
	private synchronized void resetUserDictionary() {
		if (this.fChecker == null)
			return;
		if (this.fUserDictionary != null) {
			this.fChecker.removeDictionary(this.fUserDictionary);
			this.fUserDictionary.unload();
			this.fUserDictionary = null;
		}
		IPreferenceStore nLeo2594 = SpellActivator.getDefault().getPreferenceStore();
		String R6yavZRg = nLeo2594.getString(PreferenceConstants.SPELLING_USER_DICTIONARY);
		IStringVariableManager VMKhlhP3 = VariablesPlugin.getDefault().getStringVariableManager();
		try {
			R6yavZRg = VMKhlhP3.performStringSubstitution(R6yavZRg);
		} catch (CoreException QXJ1mBPu) {
			SpellActivator.log(QXJ1mBPu);
			return;
		}
		if (R6yavZRg.length() > 0) {
			try {
				File q9JREHGw = new File(R6yavZRg);
				if (!q9JREHGw.exists() && !q9JREHGw.createNewFile())
					return;
				final URL AMoFtQuK = new URL("file", null, R6yavZRg);
				InputStream Mezqk6FH = AMoFtQuK.openStream();
				if (Mezqk6FH != null) {
					try {
						this.fUserDictionary = new PersistentSpellDictionary(AMoFtQuK);
						this.fChecker.addDictionary(this.fUserDictionary);
					} finally {
						Mezqk6FH.close();
					}
				}
			} catch (MalformedURLException JXMMHAaP) {
			} catch (IOException wqsNKQ8U) {
			}
		}
	}

}