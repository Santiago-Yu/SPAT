class n19602724{
    public static String getWikiPage(String city) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        String url = "http://api.geonames.org/wikipediaSearch?q=" + city + "&maxRows=1&lang=it&username=lorenzo.abram";
        URLConnection conn = new URL(url).openConnection();
        InputStream response = conn.getInputStream();
        GeonamesHandler handler = new GeonamesHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(response, handler);
        return handler.getUrl();
    }

}