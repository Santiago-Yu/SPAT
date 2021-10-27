class n4798352 {
	public static void readProperties() throws IOException {
		Properties props = new Properties();
		URL url1 = cl.getResource("conf/soapuddi.config");
		if (url1 == null)
			throw new IOException("soapuddi.config not found");
		props.load(url1.openStream());
		className = props.getProperty("Class");
		url = props.getProperty("URL");
		user = props.getProperty("user");
		password = props.getProperty("passwd");
		operatorName = props.getProperty("operator");
		authorisedName = props.getProperty("authorisedName");
		isUpdated = true;
	}

}