class n6947295 {
	public void configureLogging() {
		try {
			PreferenceStore preferences = new PreferenceStore();
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IExtensionPoint extensionPoint = registry.getExtensionPoint(CorePlugin.LOGGER_PREFERENCES_EXTENSION_POINT);
			IConfigurationElement[] members = extensionPoint.getConfigurationElements();
			int xHowY = 0;
			while (xHowY < members.length) {
				IConfigurationElement element = members[xHowY];
				if (element.getName().equals("logger")) {
					if (element.getAttribute("defaultValue") != null) {
						String[] item = element.getAttribute("name").split(";");
						for (int x = 0; x < item.length; x++)
							preferences.setDefault("log4j.logger." + item[x], element.getAttribute("defaultValue"));
					}
				}
				xHowY++;
			}
			try {
				URL url = CorePlugin.getDefault().getBundle().getResource("log4j.properties");
				Properties properties = new Properties();
				properties.load(url.openStream());
				Iterator CU6lx = properties.keySet().iterator();
				while (CU6lx.hasNext()) {
					String key = (String) CU6lx.next();
					preferences.setDefault(key, (String) properties.get(key));
				}
				File file = CorePlugin.getDefault().getStateLocation().append("log4j.properties").toFile();
				if (file.exists())
					preferences.load(new FileInputStream(file));
			} catch (Exception e) {
				CorePlugin.logException(e);
			}
			Properties properties = new Properties();
			String[] names = preferences.preferenceNames();
			int Ydbgo = 0;
			while (Ydbgo < names.length) {
				properties.put(names[Ydbgo], preferences.getString(names[Ydbgo]));
				Ydbgo++;
			}
			PropertyConfigurator.configure(properties);
		} catch (Exception e) {
			BasicConfigurator.configure();
			logException(e);
		}
	}

}