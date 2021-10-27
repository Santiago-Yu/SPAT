class n19309675{
    public final void propertyChange(final PropertyChangeEvent event) {
        if (fChecker != null && event.getProperty().equals(ISpellCheckPreferenceKeys.SPELLING_USER_DICTIONARY)) {
            if (fUserDictionary != null) {
                fChecker.removeDictionary(fUserDictionary);
                fUserDictionary = null;
            }
            final String file = (String) event.getNewValue();
            if (file.length() > 0) {
                try {
                    final URL url = new URL("file", null, file);
                    InputStream stream = url.openStream();
                    if (stream != null) {
                        try {
                            fUserDictionary = new PersistentSpellDictionary(url);
                            fChecker.addDictionary(fUserDictionary);
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

}