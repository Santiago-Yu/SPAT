class n18322909 {
	@Override
	public void run() {
		YouTubeFeedParserHandler HsUyh4Ap = new YouTubeFeedParserHandler();
		SAXParserFactory I9Tz6uz1 = SAXParserFactory.newInstance();
		try {
			URL Cc9EnKYy = new URL(m_YouTubeFeedUrl);
			SAXParser GdpXQDPg = I9Tz6uz1.newSAXParser();
			XMLReader YZefX1sh = GdpXQDPg.getXMLReader();
			YZefX1sh.setContentHandler(HsUyh4Ap);
			InputStream r5GWPu7n = Cc9EnKYy.openStream();
			InputSource RH7GZqJn = new InputSource(r5GWPu7n);
			YZefX1sh.parse(RH7GZqJn);
		} catch (MalformedURLException spk7qH00) {
			spk7qH00.printStackTrace();
		} catch (SAXException TJLcS9tG) {
			TJLcS9tG.printStackTrace();
		} catch (ParserConfigurationException YdmxJdZV) {
			YdmxJdZV.printStackTrace();
		} catch (IOException PFvEaccW) {
			PFvEaccW.printStackTrace();
		}
	}

}