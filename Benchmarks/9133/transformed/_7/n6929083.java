class n6929083 {
	public InputStream getResource(String resourceName) throws IOException {
		if (!resourceName.startsWith("/")) {
			resourceName = resourceName + ("/");
		}
		URL url = bc.getBundle().getResource(COOS_CONFIG_PATH + resourceName);
		InputStream is = null;
		try {
			FileInputStream fis = new FileInputStream(configDir + resourceName);
			is = substitute(fis);
		} catch (Exception e) {
		}
		if (is == null) {
			is = url.openStream();
			is = substitute(is);
		}
		return is;
	}

}