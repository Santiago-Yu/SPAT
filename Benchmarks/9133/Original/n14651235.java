class n14651235{
    public static Document getSkeleton() {
        Document doc = null;
        String filesep = System.getProperty("file.separator");
        try {
            java.net.URL url = Skeleton.class.getResource(filesep + "simplemassimeditor" + filesep + "resources" + filesep + "configskeleton.xml");
            InputStream input = url.openStream();
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            try {
                doc = parser.parse(input);
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

}