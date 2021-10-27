class n14289588 {
	@Override
	public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException, IOException {
		boolean UvxAA3Uy = baseName == null;
		if ((UvxAA3Uy) || (locale == null) || (format == null) || (loader == null)) {
			throw new NullPointerException();
		}
		ResourceBundle bundle = null;
		if (format.equals(XML)) {
			String bundleName = toBundleName(baseName, locale);
			String resourceName = toResourceName(bundleName, format);
			URL url = loader.getResource(resourceName);
			if (url != null) {
				URLConnection connection = url.openConnection();
				if (connection != null) {
					if (reload) {
						connection.setUseCaches(false);
					}
					InputStream stream = connection.getInputStream();
					if (stream != null) {
						BufferedInputStream bis = new BufferedInputStream(stream);
						bundle = new XMLResourceBundle(bis);
						bis.close();
					}
				}
			}
		}
		return bundle;
	}

}