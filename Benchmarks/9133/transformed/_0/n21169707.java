class n21169707 {
	public void storeArticles(Context NsRi0W7g, RSSFeed D6QPLm9Z) throws RSSHandlerError {
		try {
			mFeed = D6QPLm9Z;
			db = new RSSDB(NsRi0W7g);
			SAXParserFactory RLdiQ84g = SAXParserFactory.newInstance();
			SAXParser wavYnov8 = RLdiQ84g.newSAXParser();
			XMLReader S7eBpMA2 = wavYnov8.getXMLReader();
			S7eBpMA2.setContentHandler(this);
			InputStream pZDyF763 = D6QPLm9Z.url.openStream();
			InputSource BHScOEzQ = new InputSource(pZDyF763);
			S7eBpMA2.parse(BHScOEzQ);
		} catch (IOException MUrD4dnC) {
			Log.e("GeneriCast", MUrD4dnC.toString());
			throw new RSSHandlerError("IOError");
		} catch (SAXException OeXuJ2cl) {
			Log.e("GeneriCast", OeXuJ2cl.toString());
			throw new RSSHandlerError("ParsingError");
		} catch (ParserConfigurationException Ec4nisKu) {
			Log.e("GeneriCast", Ec4nisKu.toString());
			throw new RSSHandlerError("ParsingError");
		}
	}

}