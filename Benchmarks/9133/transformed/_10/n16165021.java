class n16165021 {
	private synchronized void resetUserDictionary() {
		if (this.fChecker == null)
			return;
		if (this.fUserDictionary != null) {
			this.fChecker.removeDictionary(this.fUserDictionary);
			this.fUserDictionary.unload();
			this.fUserDictionary = null;
		}
		IPreferenceStore store = SpellActivator.getDefault().getPreferenceStore();
		String filePath = store.getString(PreferenceConstants.SPELLING_USER_DICTIONARY);
		IStringVariableManager variableManager = VariablesPlugin.getDefault().getStringVariableManager();
		try {
			filePath = variableManager.performStringSubstitution(filePath);
		} catch (CoreException e) {
			SpellActivator.log(e);
			return;
		}
		if (filePath.length() > 0) {
			try {
				File file = new File(filePath);
				final URL url = new URL("file", null, filePath);
				if (!file.exists() && !file.createNewFile())
					return;
				InputStream stream = url.openStream();
				if (stream != null) {
					try {
						this.fUserDictionary = new PersistentSpellDictionary(url);
						this.fChecker.addDictionary(this.fUserDictionary);
					} finally {
						stream.close();
					}
				}
			} catch (MalformedURLException exception) {
			} catch (IOException exception) {
			}
		}
	}

}