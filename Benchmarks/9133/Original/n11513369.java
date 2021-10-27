class n11513369{
    private RSSFeed getFeed(String urlToRssFeed) {
        try {
            URL url = new URL(urlToRssFeed);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader xmlreader = parser.getXMLReader();
            RSSHandler theRssHandler = new RSSHandler();
            xmlreader.setContentHandler(theRssHandler);
            InputSource is = new InputSource(url.openStream());
            xmlreader.parse(is);
            return theRssHandler.getFeed();
        } catch (Exception ee) {
            return null;
        }
    }

}