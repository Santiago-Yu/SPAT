class n17453400 {
	public static List<PropertiesHolder> convertToPropertiesHolders(Collection<String> locations) {
		List<PropertiesHolder> propertiesHolders = new ArrayList<PropertiesHolder>();
		for (String path : locations) {
			int startIndex = path.lastIndexOf('/');
			Locale locale = null;
			if (startIndex < 0) {
				startIndex = 0;
			}
			String localeString = null;
			int localeIndex = path.indexOf('_', startIndex);
			if (localeIndex > 0) {
				localeString = path.substring(localeIndex + 1, path.lastIndexOf('.'));
			}
			if (org.apache.commons.lang.StringUtils.isBlank(localeString)) {
				locale = MessageProvider.DEFAULT_LOCALE;
				log.info("no locale could be guessed for properties: " + path);
			} else {
				locale = StringUtils.parseLocaleString(localeString);
				if (locale == null) {
					locale = Locale.getDefault();
					log.info("no locale could be guessed for properties: " + path);
				}
			}
			try {
				URL url = new URL(path);
				Properties props = new Properties();
				if (path.endsWith(".properties")) {
					props.load(url.openStream());
				} else if (path.endsWith(".xml")) {
					props.loadFromXML(url.openStream());
				} else if (path.endsWith(".xls")) {
				} else {
					log.warn("unknown filetype for properties: " + path);
				}
				String bundleName = props.getProperty("webwarp-modules-bundle-id");
				if (org.apache.commons.lang.StringUtils.isEmpty(bundleName)) {
					log.warn("bundle name is empty for path: " + path
							+ ". Provide a bundle entry 'webwarp-modules-bundle-id' to set one.");
					bundleName = MessageProvider.DEFAULT_BUNDLE_NAME;
				}
				propertiesHolders.add(new PropertiesHolder(props, bundleName, locale));
			} catch (Exception e) {
				log.error("Error reading properties from : " + path, e);
			}
		}
		return propertiesHolders;
	}

}