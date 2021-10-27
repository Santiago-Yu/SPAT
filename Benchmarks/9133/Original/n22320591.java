class n22320591{
    public static void loadProperties() {
        try {
            URL url = ClassLoader.getSystemResource("OpenDarkRoom.lang.en.properties");
            localization.load(url.openStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream is = new FileInputStream(userDir + "OpenDarkRoom.properties");
            preferences.load(is);
        } catch (FileNotFoundException e) {
            log.warn("Preferences file " + userDir + "OpenDarkRoom.properties not found, loading defaults");
            loadDefaultPreferences();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}