class n9929396 {
	private Element returnAnnoBody(final String Zh9hBaP6) {
		DOMParser SQgn5SIT = new DOMParser();
		try {
			URL TjbfNzit = new URL(Zh9hBaP6);
			URLConnection BlqsFQ3i = TjbfNzit.openConnection();
			if (useAuthorization()) {
				BlqsFQ3i.setRequestProperty("Authorization", "Basic " + getBasicAuthorizationString());
			}
			InputStream yCtbZBC0 = BlqsFQ3i.getInputStream();
			InputSource JuzdzEJN = new InputSource(yCtbZBC0);
			SQgn5SIT.parse(JuzdzEJN);
		} catch (SAXException Miv3pGN2) {
			Miv3pGN2.printStackTrace();
			return null;
		} catch (IOException sibbRyxo) {
			sibbRyxo.printStackTrace();
			return null;
		}
		Document H2enBXbm = SQgn5SIT.getDocument();
		return H2enBXbm.getDocumentElement();
	}

}