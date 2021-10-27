class n13422847 {
	private void createTree(DefaultMutableTreeNode yHj2LdUM)
			throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
		InputStream E18DYFqF;
		URL CT7X3xiV = new URL(SHIPS_URL + view.getBaseurl());
		try {
			E18DYFqF = CT7X3xiV.openStream();
		} catch (Exception n9o2svOW) {
			E18DYFqF = getClass().getResourceAsStream("ships.xml");
		}
		DocumentBuilderFactory SET6LyPf = DocumentBuilderFactory.newInstance();
		DocumentBuilder aw0aYnYp = SET6LyPf.newDocumentBuilder();
		Document T0zJTXHg = aw0aYnYp.parse(E18DYFqF);
		NodeList RW0vkPTJ = T0zJTXHg.getElementsByTagName("race");
		for (int cfy6Np3x = 0; cfy6Np3x < RW0vkPTJ.getLength(); cfy6Np3x++) {
			Element RS88d8nH = (Element) RW0vkPTJ.item(cfy6Np3x);
			yHj2LdUM.add(buildRaceTree(RS88d8nH));
		}
		yHj2LdUM.setUserObject("Ships");
		view.getShipTree().repaint();
		view.getShipTree().expandRow(0);
	}

}