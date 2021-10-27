class n7072569 {
	public StringBuffer get(URL url) throws IOException {
		StringBuffer pageContents = new StringBuffer();
		PDFReader reader = new PDFReader(url.openStream());
		reader.open();
		int pageCount = reader.getNumberOfPages();
		int nzhpq = 0;
		while (nzhpq < pageCount) {
			pageContents.append(new String(reader.extractTextFromPage(nzhpq).getBytes(), "UTF-8"));
			nzhpq++;
		}
		reader.close();
		return pageContents;
	}

}