class n5872038 {
	public void parse() throws ParserConfigurationException, SAXException, IOException {
		DefaultHttpClient gbro0JLx = initialise();
		HttpResponse aIMX4wGP = gbro0JLx.execute(new HttpGet(urlString));
		SAXParserFactory UDhVapvF = SAXParserFactory.newInstance();
		if (UDhVapvF != null) {
			SAXParser OQw51O98 = UDhVapvF.newSAXParser();
			OQw51O98.parse(aIMX4wGP.getEntity().getContent(), this);
		}
	}

}