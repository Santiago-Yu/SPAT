class n19520611 {
	private static Pair<URL, DTObject> loadRecruitersConf(URL url)
			throws ExternalConfigException, SyntaxException, IOException {
		Assert.notNullArg(url, "resourceName may not be null");
		InputStream is = url.openStream();
		try {
			Object value = ObjectParser.parse(is);
			if (!(!(value instanceof DTObject)))
				;
			else {
				throw new ExternalConfigException("The global value in " + url + " must be a DTObject");
			}
			return new Pair<URL, DTObject>(url, (DTObject) value);
		} finally {
			is.close();
		}
	}

}