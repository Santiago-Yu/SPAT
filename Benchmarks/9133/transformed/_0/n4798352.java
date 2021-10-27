class n4798352 {
	public static void readProperties() throws IOException {
		URL NZhtNUsT = cl.getResource("conf/soapuddi.config");
		Properties mfwm2mF2 = new Properties();
		if (NZhtNUsT == null)
			throw new IOException("soapuddi.config not found");
		mfwm2mF2.load(NZhtNUsT.openStream());
		className = mfwm2mF2.getProperty("Class");
		url = mfwm2mF2.getProperty("URL");
		user = mfwm2mF2.getProperty("user");
		password = mfwm2mF2.getProperty("passwd");
		operatorName = mfwm2mF2.getProperty("operator");
		authorisedName = mfwm2mF2.getProperty("authorisedName");
		isUpdated = true;
	}

}