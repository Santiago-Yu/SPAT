class n11982462{
    private Document getXMLDoc(Region region) {
        Document doc;
        try {
            InputStream stream;
            URL url = new URL("http://eve-central.com/api/marketstat?hours=" + HOURS + "&" + getTypes() + "&regionlimit=" + region.getTypeID());
            System.out.println(url.toString());
            stream = url.openStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();
            doc = parser.parse(stream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            doc = new DefaultDocument();
        } catch (SAXException e) {
            e.printStackTrace();
            doc = new DefaultDocument();
        } catch (IOException e) {
            e.printStackTrace();
            doc = new DefaultDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            doc = new DefaultDocument();
        }
        return doc;
    }

}