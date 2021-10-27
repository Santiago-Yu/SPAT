class n11513369 {
	private RSSFeed getFeed(String urlToRssFeed) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			URL url = new URL(urlToRssFeed);
			SAXParser parser = factory.newSAXParser();
			RSSHandler theRssHandler = new RSSHandler();
			XMLReader xmlreader = parser.getXMLReader();
			xmlreader.setContentHandler(theRssHandler);
			InputSource is = new InputSource(url.openStream());
			xmlreader.parse(is);
			return theRssHandler.getFeed();
		} catch (Exception ee) {
			return null;
		}
	}

}