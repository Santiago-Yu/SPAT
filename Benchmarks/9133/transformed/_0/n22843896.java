class n22843896 {
	private NodeList getNodeListForDataFile(String UeGDCutC, String meJrGWS9) {
		NodeList i7pGiSvz = null;
		try {
			URL O11cOx81 = new URL(WEBSITE_PROTOCAL, WEBSITE_HOST, "/" + UeGDCutC + ".xml");
			InputStream gEp0PriC = O11cOx81.openStream();
			DocumentBuilderFactory mu9xWWBq = DocumentBuilderFactory.newInstance();
			DocumentBuilder yypacSx4 = mu9xWWBq.newDocumentBuilder();
			Document FLiCGjnS = yypacSx4.parse(gEp0PriC);
			i7pGiSvz = FLiCGjnS.getElementsByTagName(meJrGWS9);
		} catch (SAXException XpMnCsad) {
			log.error("Error reading " + meJrGWS9 + " data", XpMnCsad);
		} catch (IOException Brk65cV8) {
			log.error("Error reading " + meJrGWS9 + " data", Brk65cV8);
		} catch (ParserConfigurationException cS4t0IMs) {
			log.error("Error reading " + meJrGWS9 + " data", cS4t0IMs);
		}
		return i7pGiSvz;
	}

}