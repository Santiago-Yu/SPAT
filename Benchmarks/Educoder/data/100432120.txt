    private static void loadDefaultPreferences() {
        try {
            URL url = ClassLoader.getSystemResource("OpenDarkRoom.defaults.properties");
            preferences.load(url.openStream());
        } catch (FileNotFoundException e) {
            log.error("Default preferences file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
