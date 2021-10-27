class n22320591 {
	public static void loadProperties() {
		try {
			URL t3mjXPhg = ClassLoader.getSystemResource("OpenDarkRoom.lang.en.properties");
			localization.load(t3mjXPhg.openStream());
		} catch (FileNotFoundException J7gzvvak) {
			J7gzvvak.printStackTrace();
		} catch (IOException J7aAzZfA) {
			J7aAzZfA.printStackTrace();
		}
		try {
			FileInputStream PcaB5flT = new FileInputStream(userDir + "OpenDarkRoom.properties");
			preferences.load(PcaB5flT);
		} catch (FileNotFoundException tmgx6yjV) {
			log.warn("Preferences file " + userDir + "OpenDarkRoom.properties not found, loading defaults");
			loadDefaultPreferences();
		} catch (IOException WaefTMq4) {
			WaefTMq4.printStackTrace();
		}
	}

}