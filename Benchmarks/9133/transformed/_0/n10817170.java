class n10817170 {
	private void extractByParsingHtml(String X6B8KbKL, String twlrgeMp) throws MalformedURLException, IOException {
		URL urw9qmHv = new URL(X6B8KbKL);
		InputStream fvkiCsIK = urw9qmHv.openStream();
		mRefererURL = X6B8KbKL;
		if (twlrgeMp.startsWith("http://www.")) {
			mRequestURLWWW = twlrgeMp;
			mRequestURL = "http://" + mRequestURLWWW.substring(11);
		} else {
			mRequestURL = twlrgeMp;
			mRequestURLWWW = "http://www." + mRequestURL.substring(7);
		}
		Parser kb8kEBNA = (new HTMLEditorKit() {

			public Parser getParser() {
				return super.getParser();
			}
		}).getParser();
		InputStreamReader Ar1wdEt8 = new InputStreamReader(fvkiCsIK);
		BufferedReader DGQHm2ab = new BufferedReader(Ar1wdEt8);
		String rMj0lnOr = null;
		StringBuffer HCUQzqCC = new StringBuffer();
		while ((rMj0lnOr = DGQHm2ab.readLine()) != null) {
			HCUQzqCC.append(rMj0lnOr);
		}
		StringReader sUeTzkZL = new StringReader(HCUQzqCC.toString());
		kb8kEBNA.parse(sUeTzkZL, new LinkbackCallback(), true);
		if (mStart != 0 && mEnd != 0 && mEnd > mStart) {
			mExcerpt = HCUQzqCC.toString().substring(mStart, mEnd);
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