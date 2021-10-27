class n8969940 {
	private void Download(String nHOCDySm) throws MalformedURLException {
		URL s8SBZMCk = new URL(nHOCDySm);
		try {
			bm = BitmapFactory.decodeStream(s8SBZMCk.openConnection().getInputStream());
		} catch (IOException AGRbwnrQ) {
			bm = getError();
		}
	}

}