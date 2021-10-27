class n18322909 {
	@Override
	public void run() {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		YouTubeFeedParserHandler parserHandler = new YouTubeFeedParserHandler();
		try {
			URL url = new URL(m_YouTubeFeedUrl);
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			xr.setContentHandler(parserHandler);
			InputStream is = url.openStream();
			InputSource input = new InputSource(is);
			xr.parse(input);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}