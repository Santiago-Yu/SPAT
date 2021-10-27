class n16280341 {
	private void mergeInDefaultMenuItemActionPerformed(java.awt.event.ActionEvent DucnGTe9) {
		try {
			String FOOuE7Ks = AutoplotUtil.getProperty("autoplot.default.bookmarks",
					"http://www.autoplot.org/data/demos.xml");
			URL kwszdNr9 = new URL(FOOuE7Ks);
			Document Yf8i3GV3 = AutoplotUtil.readDoc(kwszdNr9.openStream());
			List<Bookmark> qqmQ2G7Y = Bookmark.parseBookmarks(Yf8i3GV3.getDocumentElement());
			List<Bookmark> bIinkHX2 = new ArrayList(model.list.size());
			for (int Z74OyiO6 = 0; Z74OyiO6 < model.list.size(); Z74OyiO6++) {
				bIinkHX2.add(Z74OyiO6, model.list.get(Z74OyiO6).copy());
			}
			model.mergeList(qqmQ2G7Y, bIinkHX2);
			model.setList(bIinkHX2);
			formatToFile(bookmarksFile);
		} catch (SAXException TTo7Lr3N) {
			logger.log(Level.SEVERE, null, TTo7Lr3N);
		} catch (IOException VWoaBslU) {
			logger.log(Level.SEVERE, null, VWoaBslU);
		} catch (ParserConfigurationException j91qEw2n) {
			logger.log(Level.SEVERE, null, j91qEw2n);
		}
	}

}