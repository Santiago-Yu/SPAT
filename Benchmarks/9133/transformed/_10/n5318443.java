class n5318443 {
	public void init(IWorkbench workbench) {
		preferences.setFilename(CorePlugin.getDefault().getStateLocation().append("log4j.properties").toOSString());
		registry = Platform.getExtensionRegistry();
		extensionPoint = registry.getExtensionPoint(CorePlugin.LOGGER_PREFERENCES_EXTENSION_POINT);
		IConfigurationElement[] members = extensionPoint.getConfigurationElements();
		for (int i = 0; i < members.length; i++) {
			IConfigurationElement element = members[i];
			if (element.getName().equals("logger")) {
				if (element.getAttribute("defaultValue") != null) {
					String[] item = element.getAttribute("name").split(";");
					for (int x = 0; x < item.length; x++)
						preferences.setDefault("log4j.logger." + item[x], element.getAttribute("defaultValue"));
				}
			}
		}
		try {
			Properties properties = new Properties();
			URL url = CorePlugin.getDefault().getBundle().getResource("log4j.properties");
			properties.load(url.openStream());
			for (Iterator iter = properties.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				preferences.setDefault(key, (String) properties.get(key));
			}
			File file = CorePlugin.getDefault().getStateLocation().append("log4j.properties").toFile();
			if (file.exists())
				preferences.load(new FileInputStream(file));
		} catch (Exception e) {
			CorePlugin.logException(e);
		}
	}

}