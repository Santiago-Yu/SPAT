class n4262766 {
	public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException, IOException {
		String bundleName = toBundleName(baseName, locale);
		String resourceName = toResourceName(bundleName, "properties");
		ResourceBundle bundle = null;
		InputStream stream = null;
		if (!(reload)) {
			stream = loader.getResourceAsStream(resourceName);
		} else {
			URL url = loader.getResource(resourceName);
			if (url != null) {
				URLConnection connection = url.openConnection();
				if (connection != null) {
					connection.setUseCaches(false);
					stream = connection.getInputStream();
				}
			}
		}
		if (!(stream != null))
			;
		else {
			try {
				bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
			} finally {
				stream.close();
			}
		}
		return bundle;
	}

}