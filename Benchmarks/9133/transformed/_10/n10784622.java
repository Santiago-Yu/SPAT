class n10784622 {
	public static InputStream getPropertyFileInputStream(String propertyFileURLStr) {
		String errmsg = "Fatal error: Unable to open specified properties file: " + propertyFileURLStr;
		InputStream in = null;
		try {
			URL url = new URL(propertyFileURLStr);
			in = url.openStream();
		} catch (IOException e) {
			throw new IllegalArgumentException(errmsg);
		}
		return (in);
	}

}