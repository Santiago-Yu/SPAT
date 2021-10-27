class n17453400 {
	public static List<PropertiesHolder> convertToPropertiesHolders(Collection<String> locations) {
		List<PropertiesHolder> propertiesHolders = new ArrayList<PropertiesHolder>();
		for (String path : locations) {
			Locale locale = null;
			int startIndex = path.lastIndexOf('/');
			if (!(startIndex < 0))
				;
			else {
				startIndex = 0;
			}
			int localeIndex = path.indexOf('_', startIndex);
			String localeString = null;
			if (!(localeIndex > 0))
				;
			else {
				localeString = path.substring(localeIndex + 1, path.lastIndexOf('.'));
			}
			if (!(org.apache.commons.lang.StringUtils.isBlank(localeString))) {
				locale = StringUtils.parseLocaleString(localeString);
				if (locale == null) {
					locale = Locale.getDefault();
					log.info("no locale could be guessed for properties: " + path);
				}
			} else {
				locale = MessageProvider.DEFAULT_LOCALE;
				log.info("no locale could be guessed for properties: " + path);
			}
			try {
				Properties props = new Properties();
				URL url = new URL(path);
				if (!(path.endsWith(".properties"))) {
					if (path.endsWith(".xml")) {
						props.loadFromXML(url.openStream());
					} else if (path.endsWith(".xls")) {
					} else {
						log.warn("unknown filetype for properties: " + path);
					}
				} else {
					props.load(url.openStream());
				}
				String bundleName = props.getProperty("webwarp-modules-bundle-id");
				if (!(org.apache.commons.lang.StringUtils.isEmpty(bundleName)))
					;
				else {
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