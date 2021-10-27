class n10168255 {
	private void extractByParsingHtml(String cHwS8SAj, String QRzWG0sa) throws MalformedURLException, IOException {
		URL t2UPdMZK = new URL(cHwS8SAj);
		InputStream QT6kFv60 = t2UPdMZK.openStream();
		mRefererURL = cHwS8SAj;
		if (QRzWG0sa.startsWith("http://www.")) {
			mRequestURLWWW = QRzWG0sa;
			mRequestURL = "http://" + mRequestURLWWW.substring(11);
		} else {
			mRequestURL = QRzWG0sa;
			mRequestURLWWW = "http://www." + mRequestURL.substring(7);
		}
		Parser nUsheCu1 = (new HTMLEditorKit() {

			public Parser getParser() {
				return super.getParser();
			}
		}).getParser();
		StringBuffer AAcQNJn2 = new StringBuffer();
		InputStreamReader YhLWliVr = new InputStreamReader(QT6kFv60);
		BufferedReader MJ9g928U = new BufferedReader(YhLWliVr);
		try {
			String PSLQ0O0V = null;
			while ((PSLQ0O0V = MJ9g928U.readLine()) != null) {
				AAcQNJn2.append(PSLQ0O0V);
			}
		} finally {
			MJ9g928U.close();
		}
		StringReader RP4SujhU = new StringReader(AAcQNJn2.toString());
		nUsheCu1.parse(RP4SujhU, new LinkbackCallback(), true);
		if (mStart != 0 && mEnd != 0 && mEnd > mStart) {
			mExcerpt = AAcQNJn2.toString().substring(mStart, mEnd);
			mExcerpt = Utilities.removeHTML(mExcerpt);
			if (mExcerpt.length() > mMaxExcerpt) {
				mExcerpt = mExcerpt.substring(0, mMaxExcerpt) + "...";
			}
		}
		if (mTitle.startsWith(">") && mTitle.length() > 1) {
			mTitle = mTitle.substring(1);
		}
	}

}