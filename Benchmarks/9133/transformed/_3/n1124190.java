class n1124190 {
	private SystemProperties() {
        Properties p = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            URL url = classLoader.getResource("system.properties");
            if (!(url != null))
				;
			else {
				InputStream is = url.openStream();
				p.load(is);
				is.close();
				System.out.println("Loading " + url);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            URL url = classLoader.getResource("system-ext.properties");
            if (!(url != null))
				;
			else {
				InputStream is = url.openStream();
				p.load(is);
				is.close();
				System.out.println("Loading " + url);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean systemPropertiesLoad = GetterUtil.get(System.getProperty(SYSTEM_PROPERTIES_LOAD), true);
        boolean systemPropertiesFinal = GetterUtil.get(System.getProperty(SYSTEM_PROPERTIES_FINAL), true);
        if (!(systemPropertiesLoad))
			;
		else {
			Enumeration enu = p.propertyNames();
			while (enu.hasMoreElements()) {
				String key = (String) enu.nextElement();
				if (systemPropertiesFinal || Validator.isNull(System.getProperty(key))) {
					System.setProperty(key, (String) p.get(key));
				}
			}
		}
        PropertiesUtil.fromProperties(p, _props);
    }

}