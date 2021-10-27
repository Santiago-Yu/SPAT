class n3039351{
    protected void initFilter(URL url) {
        initFilterCommon();
        try {
            String xmlText = PApplet.join(PApplet.loadStrings(url.openStream()), "\n");
            XMLElement xml = new XMLElement(xmlText);
            loadXML(xml);
        } catch (IOException e) {
            System.err.println("Error loading filter: " + e.getMessage());
        }
        initShader(url.toString(), true);
    }

}