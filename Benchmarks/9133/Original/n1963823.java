class n1963823{
    public void loadRegistry(URL url) throws PacketAnalyzerRegistryException {
        if (analyzers != null) {
            return;
        }
        analyzers = new Hashtable();
        roots = new Vector();
        try {
            InputStream in = url.openStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse(in);
            NodeList list = doc.getElementsByTagName(PACKET_ANALYZER);
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                NamedNodeMap map = node.getAttributes();
                String id = map.getNamedItem(ID).getNodeValue();
                String name = map.getNamedItem(NAME).getNodeValue();
                String clazz = map.getNamedItem(CLASS).getNodeValue();
                Node n = map.getNamedItem(EXTENDS);
                String[] split = null;
                if (n != null) {
                    String extendedAnalyzers = n.getNodeValue();
                    if (extendedAnalyzers.trim().length() != 0) {
                        split = extendedAnalyzers.split("\\s*\\,+\\s*");
                    }
                }
                PacketAnalyzerDescriptor descriptor = new PacketAnalyzerDescriptor(id, name, clazz, split);
                addDescriptor(descriptor);
            }
            if (roots.size() == 0) {
                throw new PacketAnalyzerRegistryException("There is no root analyzer in the registry!");
            }
        } catch (IOException e) {
            throw new PacketAnalyzerRegistryException("Cannot open registry file.", e);
        } catch (ParserConfigurationException e) {
            throw new PacketAnalyzerRegistryException("Cannot parse registry file.", e);
        } catch (SAXException e) {
            throw new PacketAnalyzerRegistryException("Cannot parse registry file", e);
        } catch (Throwable e) {
            throw new PacketAnalyzerRegistryException("Cannot build PacketAnalyzerRegistry.", e);
        }
    }

}