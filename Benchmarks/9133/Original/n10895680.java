class n10895680{
    private DefaultMutableTreeNode parseTree() {
        try {
            DefaultMutableTreeNode root;
            URL url = RebusHelp.class.getResource("/org/olga/rebus/gui/help/html/content.xml");
            InputStream is = url.openStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setValidating(false);
            DocumentBuilder parser = factory.newDocumentBuilder();
            Document document = parser.parse(is);
            NodeList elements = document.getElementsByTagName("help");
            Element element = (Element) elements.item(0);
            root = createTreeContent(element);
            is.close();
            return root;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (ParserConfigurationException e1) {
            System.out.println(e1.getMessage());
            return null;
        } catch (org.xml.sax.SAXException e2) {
            System.out.println(e2.getMessage());
            return null;
        }
    }

}