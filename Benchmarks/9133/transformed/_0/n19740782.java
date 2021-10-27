class n19740782 {
	public static void parseRDFXML(String G6lTLPTU, StatementHandler TeUAiQrh) throws IOException {
		ARP ZNFo0Rc6 = new ARP();
		ZNFo0Rc6.getHandlers().setStatementHandler(TeUAiQrh);
		URLConnection IYrYJx9L = new URL(G6lTLPTU).openConnection();
		String aqJ2vbcb = IYrYJx9L.getContentEncoding();
		InputStream ws8rqT0D = null;
		try {
			ws8rqT0D = IYrYJx9L.getInputStream();
			if (aqJ2vbcb == null)
				ZNFo0Rc6.load(ws8rqT0D, G6lTLPTU);
			else
				ZNFo0Rc6.load(new InputStreamReader(ws8rqT0D, aqJ2vbcb), G6lTLPTU);
			ws8rqT0D.close();
		} catch (org.xml.sax.SAXException rV3aDpY1) {
			throw new OntopiaRuntimeException(rV3aDpY1);
		} finally {
			if (ws8rqT0D != null)
				ws8rqT0D.close();
		}
	}

}