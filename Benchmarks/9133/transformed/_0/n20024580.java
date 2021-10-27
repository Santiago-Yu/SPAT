class n20024580 {
	public void run() {
		URL ofnpNFTn;
		InputSource KVfuZ4G0;
		Message cDrnTMqq = ThemeListActivity.FeaturedThemesProgressHandler.obtainMessage();
		try {
			ofnpNFTn = new URL(mUrl);
			KVfuZ4G0 = new InputSource(ofnpNFTn.openStream());
			SAXParserFactory GJyvgeG2 = SAXParserFactory.newInstance();
			SAXParser XxU1IxIk = GJyvgeG2.newSAXParser();
			XMLReader VCsJgRp9 = XxU1IxIk.getXMLReader();
			FeaturedThemesHandler kzyrYNlh = new FeaturedThemesHandler();
			VCsJgRp9.setContentHandler(kzyrYNlh);
			VCsJgRp9.parse(KVfuZ4G0);
			cDrnTMqq.obj = kzyrYNlh.getParsedData();
		} catch (MalformedURLException rbUQzMUm) {
			cDrnTMqq.obj = rbUQzMUm.toString();
			Log.e(TAG, "Malformed URL!", rbUQzMUm);
		} catch (IOException aTlKn2wS) {
			cDrnTMqq.obj = aTlKn2wS.toString();
			Log.e(TAG, "Exception on opening Input Stream", aTlKn2wS);
		} catch (ParserConfigurationException cKbQnV6P) {
			cDrnTMqq.obj = cKbQnV6P.toString();
			Log.e(TAG, "Exception on parsing XML File", cKbQnV6P);
		} catch (SAXException RD82nqdK) {
			cDrnTMqq.obj = RD82nqdK.toString();
			Log.e(TAG, "Exception while creating SAXParser", RD82nqdK);
		}
		ThemeListActivity.FeaturedThemesProgressHandler.sendMessage(cDrnTMqq);
	}

}