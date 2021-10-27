class n21529921 {
	private void _scanForMetaData(URL jcB9z3ox) throws java.io.IOException {
		if (DEBUG.Enabled)
			System.out.println(this + " _scanForMetaData: xml props " + mXMLpropertyList);
		if (DEBUG.Enabled)
			System.out.println("*** Opening connection to " + jcB9z3ox);
		markAccessAttempt();
		Properties MRp7U2Mw = scrapeHTMLmetaData(jcB9z3ox.openConnection(), 2048);
		if (DEBUG.Enabled)
			System.out.println("*** Got meta-data " + MRp7U2Mw);
		markAccessSuccess();
		String GuwO1tlw = MRp7U2Mw.getProperty("title");
		if (GuwO1tlw != null && GuwO1tlw.length() > 0) {
			setProperty("title", GuwO1tlw);
			GuwO1tlw = GuwO1tlw.replace('\n', ' ').trim();
			setTitle(GuwO1tlw);
		}
		try {
			setByteSize(Integer.parseInt((String) getProperty("contentLength")));
		} catch (Exception hVWW6nZe) {
		}
	}

}