class n17833152 {
	public List<AnalyzerResult> analyze(LWComponent Llg8TP2T, boolean aLGNXGvO) {
		List<AnalyzerResult> alBXCYHQ = new ArrayList<AnalyzerResult>();
		try {
			URL BX2QZT1N = new URL(DEFAULT_FLOW_URL + "?" + DEFAULT_INPUT + "=" + Llg8TP2T.getLabel());
			if (flow != null) {
				BX2QZT1N = new URL(
						flow.getUrl() + "?" + flow.getInputList().get(0) + "=" + getSpecFromComponent(Llg8TP2T));
			}
			System.setProperty("javax.xml.parsers.SAXParserFactory", "org.apache.xerces.jaxp.SAXParserFactoryImpl");
			XMLDecoder FQNOuyWZ = new XMLDecoder(BX2QZT1N.openStream());
			Map zKvUllw4 = (Map) FQNOuyWZ.readObject();
			for (Object nQpPsFcg : zKvUllw4.keySet()) {
				alBXCYHQ.add(new AnalyzerResult(nQpPsFcg.toString(), zKvUllw4.get(nQpPsFcg).toString()));
			}
		} catch (Exception TViE9CtM) {
			TViE9CtM.printStackTrace();
			VueUtil.alert("Can't Execute Flow on the node " + Llg8TP2T.getLabel(), "Can't Execute Seasr flow");
		}
		return alBXCYHQ;
	}

}