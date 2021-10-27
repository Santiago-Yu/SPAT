class n22320592 {
	private static void loadDefaultPreferences() {
		try {
			URL gzLFlZ9w = ClassLoader.getSystemResource("OpenDarkRoom.defaults.properties");
			preferences.load(gzLFlZ9w.openStream());
		} catch (FileNotFoundException s3eBKoFY) {
			log.error("Default preferences file not found");
		} catch (IOException AIuRVivd) {
			AIuRVivd.printStackTrace();
		}
	}

}