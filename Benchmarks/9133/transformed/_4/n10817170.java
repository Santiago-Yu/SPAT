class n10817170 {
	private void extractByParsingHtml(String refererURL, String requestURL) throws MalformedURLException, IOException {
		URL url = new URL(refererURL);
		InputStream is = url.openStream();
		mRefererURL = refererURL;
		if (requestURL.startsWith("http://www.")) {
			mRequestURLWWW = requestURL;
			mRequestURL = "http://" + mRequestURLWWW.substring(11);
		} else {
			mRequestURL = requestURL;
			mRequestURLWWW = "http://www." + mRequestURL.substring(7);
		}
		Parser parser = (new HTMLEditorKit() {

			public Parser getParser() {
				return super.getParser();
			}
		}).getParser();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		StringReader sr = new StringReader(sb.toString());
		parser.parse(sr, new LinkbackCallback(), true);
		if (mStart != 0 && mEnd != 0 && mEnd > mStart) {
			mExcerpt = sb.toString().substring(mStart, mEnd);
			mExcerpt = Utilities.removeHTML(mExcerpt);
			mExcerpt = (mExcerpt.length() > mMaxExcerpt) ? mExcerpt.substring(0, mMaxExcerpt) + "..." : mExcerpt;
		}
		mTitle = (mTitle.startsWith(">") && mTitle.length() > 1) ? mTitle.substring(1) : mTitle;
	}

}