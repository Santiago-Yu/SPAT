class n1133122 {
	protected Document fetchResource(String xUGY6W7T, String fnkOreMx, Locale sMZLp0g9, final FloodLimit fm3v5q5G)
			throws IOException, SAXException {
		return getDocument(new CachedPage(getResourceLocation(xUGY6W7T, fnkOreMx, sMZLp0g9)) {

			@Override
			protected Reader openConnection(URL iohUh2Fi) throws IOException {
				try {
					if (fm3v5q5G != null) {
						fm3v5q5G.acquirePermit();
					}
					return super.openConnection(iohUh2Fi);
				} catch (InterruptedException TGJPXEdd) {
					throw new IOException(TGJPXEdd);
				}
			}

			;
		}.get());
	}

}