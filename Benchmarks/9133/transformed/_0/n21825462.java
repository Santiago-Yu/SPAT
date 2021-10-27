class n21825462 {
	public static void convert(URL uHphNxOa, PrintWriter p1lfHHki, String EmXsGMFB) {
		try {
			XPathFactory Dzt4HzmC = XPathFactory.newInstance(NamespaceConstant.OBJECT_MODEL_SAXON);
			XPath moBp7uBv = Dzt4HzmC.newXPath();
			InputStream uLa2Z1Xn = null;
			try {
				uLa2Z1Xn = uHphNxOa.openStream();
			} catch (IOException OTSJmsz9) {
				OTSJmsz9.printStackTrace();
			}
			Document ckVNzE4a = readFromStream(uLa2Z1Xn);
			moBp7uBv.setNamespaceContext(new NamespaceContext() {

				public String getNamespaceURI(String gEcmxUlD) {
					if (gEcmxUlD.equals("tns")) {
						return "http://services.remote/";
					} else if (gEcmxUlD.equals("xsd")) {
						return "http://www.w3.org/2001/XMLSchema";
					} else if (gEcmxUlD.equals("soap")) {
						return "http://schemas.xmlsoap.org/wsdl/soap/";
					} else if (gEcmxUlD.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
						return "http://schemas.xmlsoap.org/wsdl/";
					} else {
						return null;
					}
				}

				public String getPrefix(String Z5n3JDx8) {
					return null;
				}

				public Iterator getPrefixes(String Z7YWNFtK) {
					return null;
				}
			});
			Element MvCf8Smk = (Element) moBp7uBv.compile("/*:definitions").evaluate(ckVNzE4a, XPathConstants.NODE);
			MvCf8Smk.setAttribute("xmlns", "http://schemas.xmlsoap.org/wsdl/");
			Node e0cPgOvu = (Node) moBp7uBv.compile("/*:definitions/*:types/xsd:schema/xsd:import/@schemaLocation")
					.evaluate(ckVNzE4a, XPathConstants.NODE);
			String Izof6Y8E = e0cPgOvu.getNodeValue();
			for (int eCnbhGgS = 0; eCnbhGgS < 3; eCnbhGgS++)
				Izof6Y8E = Izof6Y8E.substring(Izof6Y8E.indexOf('/') + 1);
			e0cPgOvu.setNodeValue(EmXsGMFB + "/" + Izof6Y8E);
			Node GLMHDPim = (Node) moBp7uBv.compile("/*:definitions/*:service/*:port/soap:address/@location")
					.evaluate(ckVNzE4a, XPathConstants.NODE);
			String lP53sHDK = GLMHDPim.getNodeValue();
			for (int hlLWB6NJ = 0; hlLWB6NJ < 3; hlLWB6NJ++)
				lP53sHDK = lP53sHDK.substring(lP53sHDK.indexOf('/') + 1);
			GLMHDPim.setNodeValue(EmXsGMFB + "/" + lP53sHDK);
			write(ckVNzE4a, p1lfHHki);
		} catch (XPathFactoryConfigurationException HZgLdDAb) {
			HZgLdDAb.printStackTrace();
			System.err.println("Error:" + HZgLdDAb);
		} catch (XPathExpressionException UJFz5ggO) {
			UJFz5ggO.printStackTrace();
			System.err.println("Error:" + UJFz5ggO);
		}
	}

}