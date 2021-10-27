class n18451704 {
	public boolean isValidPage(BookPage page) {
		boolean isValid = false;
		try {
			if (page.getType() == BookPage.TYPE_RESOURCE) {
				BookPagePreviewPanel panel = new BookPagePreviewPanel(dControl, true);
				panel.setCurrentBookPage(page);
				isValid = !page.getUri().equals("") && panel.isValid();
			} else if (page.getType() == BookPage.TYPE_URL) {
				URL url = new URL(page.getUri());
				url.openStream().close();
				isValid = true;
			} else if (page.getType() == BookPage.TYPE_IMAGE) {
				isValid = (page.getUri().length() > 0) ? true : isValid;
			}
		} catch (Exception e) {
			isValid = false;
		}
		return isValid;
	}

}