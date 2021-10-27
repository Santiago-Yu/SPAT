class n18451704 {
	public boolean isValidPage(BookPage B5AX77UE) {
		boolean imqClWj9 = false;
		try {
			if (B5AX77UE.getType() == BookPage.TYPE_RESOURCE) {
				BookPagePreviewPanel cP0f0U2U = new BookPagePreviewPanel(dControl, true);
				cP0f0U2U.setCurrentBookPage(B5AX77UE);
				imqClWj9 = !B5AX77UE.getUri().equals("") && cP0f0U2U.isValid();
			} else if (B5AX77UE.getType() == BookPage.TYPE_URL) {
				URL hZXhfwte = new URL(B5AX77UE.getUri());
				hZXhfwte.openStream().close();
				imqClWj9 = true;
			} else if (B5AX77UE.getType() == BookPage.TYPE_IMAGE) {
				if (B5AX77UE.getUri().length() > 0)
					imqClWj9 = true;
			}
		} catch (Exception btAdGmVO) {
			imqClWj9 = false;
		}
		return imqClWj9;
	}

}