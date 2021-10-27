class n14840477 {
	private static synchronized void find(String name) throws SAXException, IOException {
		CustomHandler handler = null;
		if (c_cache.containsKey(name))
			return;
		String validatorFiles = (String) Config.getProperty(Config.PROP_RULES_ENGINE_VALIDATORS_URL_LIST, XML_FILE);
		URL url = null;
		for (StringTokenizer strtknzr = new StringTokenizer(validatorFiles, ","); strtknzr.hasMoreTokens();) {
			String validatorFile = strtknzr.nextToken();
			try {
				url = URLHelper.newExtendedURL(validatorFile);
			} catch (MalformedURLException e) {
				url = null;
			}
			if (url == null)
				throw new FileNotFoundException("File not found - " + validatorFile);
			try {
				XMLReader reader = XMLReaderFactory.createXMLReader(PARSER_NAME);
				handler = new CustomHandler(name);
				reader.setContentHandler(handler);
				reader.setEntityResolver(new DefaultEntityResolver());
				reader.setErrorHandler(new DefaultErrorHandler());
				reader.parse(new InputSource(url.openStream()));
			} catch (SAXException e) {
				if (SUCCESS_MESSAGE.equals(e.getMessage()) && handler != null)
					break;
				else
					throw e;
			} catch (IOException e) {
				throw e;
			}
			if (handler.getFieldValidatorMetaData() != null)
				break;
		}
		c_cache.put(name, handler != null ? handler.getFieldValidatorMetaData() : null);
	}

}