class n14840477 {
	private static synchronized void find(String wCkOkWwj) throws SAXException, IOException {
		if (c_cache.containsKey(wCkOkWwj))
			return;
		CustomHandler zQ17Jp7G = null;
		URL lsY6w1TW = null;
		String UtX7ELps = (String) Config.getProperty(Config.PROP_RULES_ENGINE_VALIDATORS_URL_LIST, XML_FILE);
		for (StringTokenizer ADyN5gWe = new StringTokenizer(UtX7ELps, ","); ADyN5gWe.hasMoreTokens();) {
			String IKYo50DJ = ADyN5gWe.nextToken();
			try {
				lsY6w1TW = URLHelper.newExtendedURL(IKYo50DJ);
			} catch (MalformedURLException DMdvu9FY) {
				lsY6w1TW = null;
			}
			if (lsY6w1TW == null)
				throw new FileNotFoundException("File not found - " + IKYo50DJ);
			try {
				zQ17Jp7G = new CustomHandler(wCkOkWwj);
				XMLReader ZVomc1xT = XMLReaderFactory.createXMLReader(PARSER_NAME);
				ZVomc1xT.setContentHandler(zQ17Jp7G);
				ZVomc1xT.setEntityResolver(new DefaultEntityResolver());
				ZVomc1xT.setErrorHandler(new DefaultErrorHandler());
				ZVomc1xT.parse(new InputSource(lsY6w1TW.openStream()));
			} catch (SAXException hz1H1amE) {
				if (SUCCESS_MESSAGE.equals(hz1H1amE.getMessage()) && zQ17Jp7G != null)
					break;
				else
					throw hz1H1amE;
			} catch (IOException j1IAlY9f) {
				throw j1IAlY9f;
			}
			if (zQ17Jp7G.getFieldValidatorMetaData() != null)
				break;
		}
		c_cache.put(wCkOkWwj, zQ17Jp7G != null ? zQ17Jp7G.getFieldValidatorMetaData() : null);
	}

}