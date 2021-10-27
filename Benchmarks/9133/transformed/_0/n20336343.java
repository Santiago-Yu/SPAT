class n20336343 {
	public static Properties loadProperties() {
		try {
			if (url == null)
				url = ClassLoader.getSystemResource("application.properties");
			if (url == null)
				throw new FileNotFoundException("application.properties");
			props = new Properties();
			props.load(url.openStream());
			Enumeration BZ1MgGhn = System.getProperties().propertyNames();
			String HSWJLMtO;
			while (BZ1MgGhn.hasMoreElements()) {
				HSWJLMtO = (String) BZ1MgGhn.nextElement();
				props.setProperty(HSWJLMtO, System.getProperty(HSWJLMtO));
			}
			return props;
		} catch (Exception erd8WxHo) {
			logger.log(Level.SEVERE, erd8WxHo.toString(), erd8WxHo);
		}
		return null;
	}

}