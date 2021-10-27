class n1931703 {
	public GPSTrace loadGPSTrace(long n5l35kLM) {
		try {
			URL f9YlIfaC = new URL(SERVER_URL + XML_PATH + "gps.xml");
			System.out.println(f9YlIfaC);
			DocumentBuilderFactory olYOgEC7 = DocumentBuilderFactory.newInstance();
			DocumentBuilder OfPZqFE6 = olYOgEC7.newDocumentBuilder();
			document = OfPZqFE6.parse(f9YlIfaC.openStream());
			Element XtyBd1rP = document.getDocumentElement();
			NodeList FtAyjQHr = XtyBd1rP.getElementsByTagName("gps");
			trace = getGPSTrace(FtAyjQHr);
		} catch (SAXException FVMcWiu8) {
			Exception hq5eLIib = FVMcWiu8;
			if (FVMcWiu8.getException() != null)
				hq5eLIib = FVMcWiu8.getException();
			hq5eLIib.printStackTrace();
		} catch (ParserConfigurationException X2njNb8t) {
			X2njNb8t.printStackTrace();
		} catch (IOException PIUCE0m7) {
			PIUCE0m7.printStackTrace();
		}
		return trace;
	}

}