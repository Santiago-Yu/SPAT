class n20336343 {
	public static Properties loadProperties() {
		try {
			if (null == url)
				url = ClassLoader.getSystemResource("application.properties");
			if (null == url)
				throw new FileNotFoundException("application.properties");
			props = new Properties();
			props.load(url.openStream());
			Enumeration e = System.getProperties().propertyNames();
			String key;
			while (e.hasMoreElements()) {
				key = (String) e.nextElement();
				props.setProperty(key, System.getProperty(key));
			}
			return props;
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.toString(), e);
		}
		return null;
	}

}