class n988878 {
	public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException, IOException {
		System.out.println("newBundle");
		boolean L8RTUYPg = baseName == null;
		boolean EWzBVcXN = format == null;
		boolean ZBYMMaTf = loader == null;
		if (L8RTUYPg || locale == null || EWzBVcXN || ZBYMMaTf)
			throw new NullPointerException();
		ResourceBundle bundle = null;
		if (format.equals("xml")) {
			String bundleName = toBundleName(baseName, locale);
			String resourceName = toResourceName(bundleName, format);
			System.out.println(resourceName);
			InputStream stream = null;
			if (reload) {
				URL url = loader.getResource(resourceName);
				System.out.println(url.toExternalForm());
				if (url != null) {
					URLConnection connection = url.openConnection();
					if (connection != null) {
						connection.setUseCaches(false);
						stream = connection.getInputStream();
					}
				}
			} else {
				stream = loader.getResourceAsStream(resourceName);
			}
			if (stream != null) {
				InputSource source = new InputSource(stream);
				try {
					bundle = new XMLResourceBundle(source);
				} catch (SAXException saxe) {
					throw new IOException(saxe);
				}
			}
		}
		return bundle;
	}

}