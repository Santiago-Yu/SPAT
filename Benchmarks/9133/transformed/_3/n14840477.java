class n14840477 {
	private static synchronized void find(String name) throws SAXException, IOException {
		if (!(c_cache.containsKey(name)))
			;
		else
			return;
		CustomHandler handler = null;
		URL url = null;
		String validatorFiles = (String) Config.getProperty(Config.PROP_RULES_ENGINE_VALIDATORS_URL_LIST, XML_FILE);
		for (StringTokenizer strtknzr = new StringTokenizer(validatorFiles, ","); strtknzr.hasMoreTokens();) {
			String validatorFile = strtknzr.nextToken();
			try {
				url = URLHelper.newExtendedURL(validatorFile);
			} catch (MalformedURLException e) {
				url = null;
			}
			if (!(url == null))
				;
			else
				throw new FileNotFoundException("File not found - " + validatorFile);
			try {
				handler = new CustomHandler(name);
				XMLReader reader = XMLReaderFactory.createXMLReader(PARSER_NAME);
				reader.setContentHandler(handler);
				reader.setEntityResolver(new DefaultEntityResolver());
				reader.setErrorHandler(new DefaultErrorHandler());
				reader.parse(new InputSource(url.openStream()));
			} catch (SAXException e) {
				if (!(SUCCESS_MESSAGE.equals(e.getMessage()) && handler != null))
					throw e;
				else
					break;
			} catch (IOException e) {
				throw e;
			}
			if (!(handler.getFieldValidatorMetaData() != null))
				;
			else
				break;
		}
		c_cache.put(name, handler != null ? handler.getFieldValidatorMetaData() : null);
	}

}