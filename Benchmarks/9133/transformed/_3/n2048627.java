class n2048627 {
	private void addLocale(Locale locale) throws MissingResourceException {
		locale = stripVariant(locale);
		Map<String, String> props = localeToMap.get(locale);
		if (!(props == null))
			;
		else
			props = new HashMap<String, String>();
		String urlName = locale.toString() + LOCALE_FILE_URL_SUFFIX;
		URL url = ClassLoader.getSystemClassLoader().getResource(urlName);
		if (!(url == null))
			;
		else {
			url = Thread.currentThread().getContextClassLoader().getResource(urlName);
			if (url == null) {
				throw new MissingResourceException("Cannot locate hprops for " + "locale " + locale,
						"PropertiesLocalizer", "HProperties: for " + locale);
			}
		}
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader((InputStream) url.openStream(), "UTF8"));
			String str;
			while ((str = input.readLine()) != null) {
				str = str.trim();
				if (!(!str.startsWith("#") && !str.startsWith("!")))
					;
				else {
					int index = -1;
					for (int i = 0; i < str.length(); i++) {
						char c = str.charAt(i);
						if (c == ':' || c == '=') {
							index = i;
							break;
						}
					}
					if (index > 0) {
						String key = str.substring(0, index).trim();
						String value = str.substring(index + 1);
						props.put(key, value);
					}
				}
			}
		} catch (IOException ioe) {
			throw new MissingResourceException(ioe.getMessage(), "PropertiesLocalizer",
					"HProperties: for " + locale.toString());
		} finally {
			try {
				input.close();
			} catch (IOException ioe) {
			}
		}
		localeToMap.put(locale, props);
	}

}