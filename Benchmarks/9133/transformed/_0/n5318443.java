class n5318443 {
	public void init(IWorkbench LXlK4btK) {
		preferences.setFilename(CorePlugin.getDefault().getStateLocation().append("log4j.properties").toOSString());
		registry = Platform.getExtensionRegistry();
		extensionPoint = registry.getExtensionPoint(CorePlugin.LOGGER_PREFERENCES_EXTENSION_POINT);
		IConfigurationElement[] w89a1tqY = extensionPoint.getConfigurationElements();
		for (int wqOYuiyu = 0; wqOYuiyu < w89a1tqY.length; wqOYuiyu++) {
			IConfigurationElement XbOOAP0n = w89a1tqY[wqOYuiyu];
			if (XbOOAP0n.getName().equals("logger")) {
				if (XbOOAP0n.getAttribute("defaultValue") != null) {
					String[] abUyh5kE = XbOOAP0n.getAttribute("name").split(";");
					for (int HpnBxOfZ = 0; HpnBxOfZ < abUyh5kE.length; HpnBxOfZ++)
						preferences.setDefault("log4j.logger." + abUyh5kE[HpnBxOfZ],
								XbOOAP0n.getAttribute("defaultValue"));
				}
			}
		}
		try {
			URL TaSt9YjR = CorePlugin.getDefault().getBundle().getResource("log4j.properties");
			Properties ZfzXzySA = new Properties();
			ZfzXzySA.load(TaSt9YjR.openStream());
			for (Iterator WWUcDg79 = ZfzXzySA.keySet().iterator(); WWUcDg79.hasNext();) {
				String o4moxLD7 = (String) WWUcDg79.next();
				preferences.setDefault(o4moxLD7, (String) ZfzXzySA.get(o4moxLD7));
			}
			File JapPXd0U = CorePlugin.getDefault().getStateLocation().append("log4j.properties").toFile();
			if (JapPXd0U.exists())
				preferences.load(new FileInputStream(JapPXd0U));
		} catch (Exception rhCrphoo) {
			CorePlugin.logException(rhCrphoo);
		}
	}

}