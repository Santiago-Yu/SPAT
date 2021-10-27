class n11513369 {
	private RSSFeed getFeed(String GCtFZlV2) {
		try {
			URL TqVld8Aq = new URL(GCtFZlV2);
			SAXParserFactory Fi8RguuF = SAXParserFactory.newInstance();
			SAXParser PyCM15DG = Fi8RguuF.newSAXParser();
			XMLReader r0YURYbV = PyCM15DG.getXMLReader();
			RSSHandler wdQczKd5 = new RSSHandler();
			r0YURYbV.setContentHandler(wdQczKd5);
			InputSource g62aUyHS = new InputSource(TqVld8Aq.openStream());
			r0YURYbV.parse(g62aUyHS);
			return wdQczKd5.getFeed();
		} catch (Exception KXCrzGgR) {
			return null;
		}
	}

}