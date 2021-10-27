class n13653107 {
	public static void loadConfig(DeviceEntry WImP5Wr2, EmulatorContext YMo9Ulwg) {
		Config.defaultDevice = WImP5Wr2;
		Config.emulatorContext = YMo9Ulwg;
		File WIeYldua = new File(getConfigPath(), "config2.xml");
		try {
			if (WIeYldua.exists()) {
				loadConfigFile("config2.xml");
			} else {
				WIeYldua = new File(getConfigPath(), "config.xml");
				if (WIeYldua.exists()) {
					loadConfigFile("config.xml");
					for (Enumeration cAfihaY8 = getDeviceEntries().elements(); cAfihaY8.hasMoreElements();) {
						DeviceEntry fQnj25lf = (DeviceEntry) cAfihaY8.nextElement();
						if (!fQnj25lf.canRemove()) {
							continue;
						}
						removeDeviceEntry(fQnj25lf);
						File S8hnH2Qt = new File(getConfigPath(), fQnj25lf.getFileName());
						File NiUkKTTE = File.createTempFile("dev", ".jar", getConfigPath());
						IOUtils.copyFile(S8hnH2Qt, NiUkKTTE);
						fQnj25lf.setFileName(NiUkKTTE.getName());
						addDeviceEntry(fQnj25lf);
					}
				} else {
					createDefaultConfigXml();
				}
				saveConfig();
			}
		} catch (IOException Veo3OQ66) {
			Logger.error(Veo3OQ66);
			createDefaultConfigXml();
		} finally {
			if (configXml == null) {
				createDefaultConfigXml();
			}
		}
		urlsMRU.read(configXml.getChildOrNew("files").getChildOrNew("recent"));
		initSystemProperties();
	}

}