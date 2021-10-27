class n4213253{
    public VersionInfo getVersionInfo(String url) {
        try {
            XmlContentHandler handler = new XmlContentHandler();
            XMLReader myReader = XMLReaderFactory.createXMLReader();
            myReader.setContentHandler(handler);
            myReader.parse(new InputSource(new URL(url).openStream()));
            return handler.getVersionInfo();
        } catch (SAXException e) {
            if (debug) {
                println("SAXException was thrown!");
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            if (debug) {
                println("MalformedURLException was thrown!");
                e.printStackTrace();
            }
        } catch (IOException e) {
            if (debug) {
                println("IOException was thrown!");
                e.printStackTrace();
            }
        }
        return null;
    }

}