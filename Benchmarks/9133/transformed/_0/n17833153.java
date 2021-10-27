class n17833153 {
	public List<AnalyzerResult> analyze(String SVJitK11, boolean hfqcE77s) {
		List<AnalyzerResult> j0Uqo0L6 = new ArrayList<AnalyzerResult>();
		try {
			URL WG3iiLQR;
			if (flow == null) {
				WG3iiLQR = new URL(DEFAULT_FLOW_URL + "?" + DEFAULT_INPUT + "=" + SVJitK11);
			} else {
				WG3iiLQR = new URL(flow.getUrl() + "?" + flow.getInputList().get(0) + "=" + SVJitK11);
			}
			System.setProperty("javax.xml.parsers.SAXParserFactory", "org.apache.xerces.jaxp.SAXParserFactoryImpl");
			System.out.println("Executing: " + WG3iiLQR.toString());
			XMLDecoder UAReb1B2 = new XMLDecoder(WG3iiLQR.openStream());
			Map aIEac7sk = (Map) UAReb1B2.readObject();
			for (Object UeGndNXI : aIEac7sk.keySet()) {
				j0Uqo0L6.add(new AnalyzerResult(UeGndNXI.toString(), aIEac7sk.get(UeGndNXI).toString()));
			}
		} catch (Exception NRefgD4b) {
			NRefgD4b.printStackTrace();
			VueUtil.alert("Can't Execute Flow on the url " + SVJitK11, "Can't Execute Seasr flow");
		}
		return j0Uqo0L6;
	}

}