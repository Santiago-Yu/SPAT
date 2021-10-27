class n18451704 {
	public boolean isValidPage(BookPage page) {
		boolean isValid = false;
		try {
			if (BookPage.TYPE_RESOURCE == page.getType()) {
				BookPagePreviewPanel panel = new BookPagePreviewPanel(dControl, true);
				panel.setCurrentBookPage(page);
				isValid = !page.getUri().equals("") && panel.isValid();
			} else if (BookPage.TYPE_URL == page.getType()) {
				URL url = new URL(page.getUri());
				url.openStream().close();
				isValid = true;
			} else if (BookPage.TYPE_IMAGE == page.getType()) {
				if (page.getUri().length() > 0)
					isValid = true;
			}
		} catch (Exception e) {
			isValid = false;
		}
		return isValid;
	}

}