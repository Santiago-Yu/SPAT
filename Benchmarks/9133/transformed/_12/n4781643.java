class n4781643 {
	public static void loadConfig(URL urlFile) throws CacheException {
		Document document;
		try {
			document = Utilities.getDocument(urlFile.openStream());
		} catch (IOException e) {
			throw new CacheException("Could not open '" + urlFile.getFile() + "'", e);
		} catch (JAnalyticsException e) {
			throw new CacheException("Could not open '" + urlFile.getFile() + "'", e);
		}
		Element element = (Element) document.getElementsByTagName(DOCUMENT_CACHE_ELEMENT_NAME).item(0);
		if (element != null) {
			String className = element.getAttribute(CLASSNAME_ATTRIBUTE_NAME);
			if (className != null) {
				Properties config = new Properties();
				NodeList nodes = element.getElementsByTagName(PARAM_ELEMENT_NAME);
				if (nodes != null) {
					for (int i = 0, count = nodes.getLength(); i < count; i++) {
						Node node = nodes.item(i);
						if (node instanceof Element) {
							Element n = (Element) node;
							String name = n.getAttribute(NAME_ATTRIBUTE_NAME),
									value = n.getAttribute(VALUE_ATTRIBUTE_NAME);
							config.put(name, value);
						}
					}
				}
				loadConfig(className, config);
			}
		}
	}

}