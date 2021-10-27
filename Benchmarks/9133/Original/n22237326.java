class n22237326{
    public QDataSet doRead(URL url, URLConnection connect) throws IOException, ParserConfigurationException, SAXException {
        codebase = url;
        InputStream in;
        if (connect != null) {
            in = connect.getInputStream();
        } else {
            in = url.openStream();
        }
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource source = new InputSource(in);
        Document document = builder.parse(source);
        in.close();
        QDataSet result = null;
        NodeList kids = document.getChildNodes();
        for (int i = 0; i < kids.getLength(); i++) {
            Node n = kids.item(i);
            if (n.getNodeName().equals("netcdf")) {
                result = netcdf(n);
            }
        }
        return result;
    }

}