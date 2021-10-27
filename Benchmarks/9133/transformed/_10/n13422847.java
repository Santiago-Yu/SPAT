class n13422847 {
	private void createTree(DefaultMutableTreeNode top)
			throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
		URL url = new URL(SHIPS_URL + view.getBaseurl());
		InputStream stream;
		try {
			stream = url.openStream();
		} catch (Exception e) {
			stream = getClass().getResourceAsStream("ships.xml");
		}
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document doc = parser.parse(stream);
		NodeList races = doc.getElementsByTagName("race");
		for (int i = 0; i < races.getLength(); i++) {
			Element race = (Element) races.item(i);
			top.add(buildRaceTree(race));
		}
		top.setUserObject("Ships");
		view.getShipTree().repaint();
		view.getShipTree().expandRow(0);
	}

}