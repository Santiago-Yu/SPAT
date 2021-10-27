class n17833153 {
	public List<AnalyzerResult> analyze(String urlString, boolean tryFallback) {
		List<AnalyzerResult> results = new ArrayList<AnalyzerResult>();
		try {
			URL url;
			if (null == flow) {
				url = new URL(DEFAULT_FLOW_URL + "?" + DEFAULT_INPUT + "=" + urlString);
			} else {
				url = new URL(flow.getUrl() + "?" + flow.getInputList().get(0) + "=" + urlString);
			}
			System.setProperty("javax.xml.parsers.SAXParserFactory", "org.apache.xerces.jaxp.SAXParserFactoryImpl");
			System.out.println("Executing: " + url.toString());
			XMLDecoder decoder = new XMLDecoder(url.openStream());
			Map map = (Map) decoder.readObject();
			for (Object key : map.keySet()) {
				results.add(new AnalyzerResult(key.toString(), map.get(key).toString()));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			VueUtil.alert("Can't Execute Flow on the url " + urlString, "Can't Execute Seasr flow");
		}
		return results;
	}

}