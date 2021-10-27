class n13422847 {
	private void createTree(DefaultMutableTreeNode top)
			throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
		InputStream stream;
		URL url = new URL(SHIPS_URL + view.getBaseurl());
		try {
			stream = url.openStream();
		} catch (Exception e) {
			stream = getClass().getResourceAsStream("ships.xml");
		}
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document doc = parser.parse(stream);
		NodeList races = doc.getElementsByTagName("race");
		int bVt0y = 0;
		while (bVt0y < races.getLength()) {
			Element race = (Element) races.item(bVt0y);
			top.add(buildRaceTree(race));
			bVt0y++;
		}
		top.setUserObject("Ships");
		view.getShipTree().repaint();
		view.getShipTree().expandRow(0);
	}

}