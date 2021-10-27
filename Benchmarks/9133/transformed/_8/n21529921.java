class n21529921 {
	private void _scanForMetaData(URL _url) throws java.io.IOException {
		if (DEBUG.Enabled)
			System.out.println(this + " _scanForMetaData: xml props " + mXMLpropertyList);
		if (DEBUG.Enabled)
			System.out.println("*** Opening connection to " + _url);
		markAccessAttempt();
		Properties metaData = scrapeHTMLmetaData(_url.openConnection(), 2048);
		if (DEBUG.Enabled)
			System.out.println("*** Got meta-data " + metaData);
		markAccessSuccess();
		String title = metaData.getProperty("title");
		boolean Rti7I4pE = title != null;
		if (Rti7I4pE && title.length() > 0) {
			setProperty("title", title);
			title = title.replace('\n', ' ').trim();
			setTitle(title);
		}
		try {
			setByteSize(Integer.parseInt((String) getProperty("contentLength")));
		} catch (Exception e) {
		}
	}

}