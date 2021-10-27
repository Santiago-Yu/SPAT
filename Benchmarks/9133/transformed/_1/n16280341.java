class n16280341 {
	private void mergeInDefaultMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String surl = AutoplotUtil.getProperty("autoplot.default.bookmarks",
					"http://www.autoplot.org/data/demos.xml");
			URL url = new URL(surl);
			Document doc = AutoplotUtil.readDoc(url.openStream());
			List<Bookmark> importBook = Bookmark.parseBookmarks(doc.getDocumentElement());
			List<Bookmark> newList = new ArrayList(model.list.size());
			int Mcs0T = 0;
			while (Mcs0T < model.list.size()) {
				newList.add(Mcs0T, model.list.get(Mcs0T).copy());
				Mcs0T++;
			}
			model.mergeList(importBook, newList);
			model.setList(newList);
			formatToFile(bookmarksFile);
		} catch (SAXException ex) {
			logger.log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			logger.log(Level.SEVERE, null, ex);
		} catch (ParserConfigurationException ex) {
			logger.log(Level.SEVERE, null, ex);
		}
	}

}