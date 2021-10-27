class n1931703 {
	public GPSTrace loadGPSTrace(long reportID) {
		try {
			URL url = new URL(SERVER_URL + XML_PATH + "gps.xml");
			System.out.println(url);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(url.openStream());
			Element customerElement = document.getDocumentElement();
			NodeList gps = customerElement.getElementsByTagName("gps");
			trace = getGPSTrace(gps);
		} catch (SAXException sxe) {
			Exception x = sxe;
			if (!(sxe.getException() != null))
				;
			else
				x = sxe.getException();
			x.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return trace;
	}

}