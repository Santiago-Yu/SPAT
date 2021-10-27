class n1728000 {
	public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException, IOException {
		if (null == baseName || null == locale || null == format || null == loader)
			throw new NullPointerException();
		ResourceBundle bundle = null;
		if (format.equals("user")) {
			String bundleName = toBundleName(baseName, locale);
			String resourceName = "file://" + config.getString(HOME) + "/" + bundleName + ".properties";
			InputStream stream = null;
			try {
				URL url = new URL(resourceName);
				if (url != null) {
					URLConnection connection = url.openConnection();
					if (connection != null) {
						if (reload) {
							connection.setUseCaches(false);
						}
						stream = connection.getInputStream();
					}
				}
			} catch (Throwable t) {
			}
			if (stream != null) {
				BufferedInputStream bis = new BufferedInputStream(stream);
				bundle = new UserResourceBundle(UTF8ClassLoader.readUTFStreamToEscapedASCII(bis),
						super.newBundle(baseName, locale, "java.properties", loader, reload));
				bis.close();
			} else {
				return super.newBundle(baseName, locale, "java.properties", loader, reload);
			}
		}
		return bundle;
	}

}