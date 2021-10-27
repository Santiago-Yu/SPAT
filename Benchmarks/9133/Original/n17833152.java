class n17833152{
    public List<AnalyzerResult> analyze(LWComponent c, boolean tryFallback) {
        List<AnalyzerResult> results = new ArrayList<AnalyzerResult>();
        try {
            URL url = new URL(DEFAULT_FLOW_URL + "?" + DEFAULT_INPUT + "=" + c.getLabel());
            if (flow != null) {
                url = new URL(flow.getUrl() + "?" + flow.getInputList().get(0) + "=" + getSpecFromComponent(c));
            }
            System.setProperty("javax.xml.parsers.SAXParserFactory", "org.apache.xerces.jaxp.SAXParserFactoryImpl");
            XMLDecoder decoder = new XMLDecoder(url.openStream());
            Map map = (Map) decoder.readObject();
            for (Object key : map.keySet()) {
                results.add(new AnalyzerResult(key.toString(), map.get(key).toString()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            VueUtil.alert("Can't Execute Flow on the node " + c.getLabel(), "Can't Execute Seasr flow");
        }
        return results;
    }

}