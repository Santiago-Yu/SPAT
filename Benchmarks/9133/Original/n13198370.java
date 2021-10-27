class n13198370{
    public XMLResourceBundle() throws MissingResourceException {
        String systemId = getShortName() + ".xml";
        URL url;
        if ((url = getClass().getResource(systemId)) != null) {
            InputStream is = null;
            try {
                is = url.openStream();
                SAXParserFactory factory = SAXParserFactory.newInstance();
                factory.setNamespaceAware(false);
                factory.setValidating(false);
                XMLReader xmlReader = factory.newSAXParser().getXMLReader();
                xmlReader.setContentHandler(new MessageContentHandler());
                xmlReader.parse(new InputSource(is));
            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
                ioe.printStackTrace();
            } catch (SAXException se) {
                System.err.println(se.getMessage());
                se.printStackTrace();
            } catch (ParserConfigurationException pce) {
                System.err.println(pce.getMessage());
                pce.printStackTrace();
            } finally {
                try {
                    if (is != null) is.close();
                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                    ioe.printStackTrace();
                }
            }
        } else {
            throw new MissingResourceException("Resource file '" + systemId + "' could not be found.", systemId, null);
        }
    }

}