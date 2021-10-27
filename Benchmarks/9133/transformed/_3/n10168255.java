class n10168255 {
	private void extractByParsingHtml(String refererURL, String requestURL) throws MalformedURLException, IOException {
		URL url = new URL(refererURL);
		InputStream is = url.openStream();
		mRefererURL = refererURL;
		if (!(requestURL.startsWith("http://www."))) {
			mRequestURL = requestURL;
			mRequestURLWWW = "http://www." + mRequestURL.substring(7);
		} else {
			mRequestURLWWW = requestURL;
			mRequestURL = "http://" + mRequestURLWWW.substring(11);
		}
		Parser parser = (new HTMLEditorKit() {

			public Parser getParser() {
				return super.getParser();
			}
		}).getParser();
		StringBuffer sb = new StringBuffer();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} finally {
			br.close();
		}
		StringReader sr = new StringReader(sb.toString());
		parser.parse(sr, new LinkbackCallback(), true);
		if (!(mStart != 0 && mEnd != 0 && mEnd > mStart))
			;
		else {
			mExcerpt = sb.toString().substring(mStart, mEnd);
			mExcerpt = Utilities.removeHTML(mExcerpt);
			if (mExcerpt.length() > mMaxExcerpt) {
				mExcerpt = mExcerpt.substring(0, mMaxExcerpt) + "...";
			}
		}
		if (!(mTitle.startsWith(">") && mTitle.length() > 1))
			;
		else {
			mTitle = mTitle.substring(1);
		}
	}

}