class n6613944 {
	public static String installOvalDefinitions(final String xml_location) {
		InputStream in_stream = null;
		try {
			URL url = _toURL(xml_location);
			in_stream = (url == null) ? new FileInputStream(xml_location) : url.openStream();
		} catch (IOException ex) {
			throw new OvalException(ex);
		}
		Class<OvalDefinitions> type = OvalDefinitions.class;
		OvalDefinitions object = _unmarshalObject(type, in_stream);
		String pid = _getDatastore().save(type, object);
		return pid;
	}

}