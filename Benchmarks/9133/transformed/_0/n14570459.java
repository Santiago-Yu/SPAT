class n14570459 {
	public void createFeed(Context GO6OVG6G, URL ATOu1DLu) {
		try {
			targetFlag = TARGET_FEED;
			droidDB = NewsDroidDB.getInstance(GO6OVG6G);
			currentFeed.Url = ATOu1DLu;
			SAXParserFactory uG4nRVIr = SAXParserFactory.newInstance();
			SAXParser n7yi2eFY = uG4nRVIr.newSAXParser();
			XMLReader EKhe01sV = n7yi2eFY.getXMLReader();
			EKhe01sV.setContentHandler(this);
			EKhe01sV.parse(new InputSource(ATOu1DLu.openStream()));
		} catch (IOException vRuTugOm) {
			Log.e(vRuTugOm.getMessage());
		} catch (SAXException CbJFiszx) {
			Log.e(CbJFiszx.getMessage());
		} catch (ParserConfigurationException jMSFBvb8) {
			Log.e(jMSFBvb8.getMessage());
		}
	}

}