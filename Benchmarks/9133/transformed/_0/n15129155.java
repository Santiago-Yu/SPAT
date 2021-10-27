class n15129155 {
	public List<String> extractUrlList(String tgAnQhoM) throws IOException, XPathExpressionException {
		LinkedList<String> WKJJmmR4 = new LinkedList<String>();
		HttpURLConnection dmlkji4R = (HttpURLConnection) new URL(tgAnQhoM).openConnection();
		Tidy vGbS1FHa = new Tidy();
		vGbS1FHa.setErrout(new NullPrintWriter());
		Document yZmmq7wh = vGbS1FHa.parseDOM(dmlkji4R.getInputStream(), null);
		int mxLiVg0F = dmlkji4R.getContentLength();
		if (mxLiVg0F <= 0)
			mxLiVg0F = 32000;
		ByteArrayOutputStream Rq7xuTMg = new ByteArrayOutputStream(mxLiVg0F);
		PrintStream rV2gqGeN = new PrintStream(Rq7xuTMg);
		vGbS1FHa.pprint(yZmmq7wh, rV2gqGeN);
		rV2gqGeN.flush();
		String lNwc0aeX = Rq7xuTMg.toString();
		Pattern nig3uDR8 = Pattern.compile("(http://[\\w\\\\\\./=&?;-]+)");
		Matcher sju2pcJT = nig3uDR8.matcher(lNwc0aeX);
		while (sju2pcJT.find()) {
			WKJJmmR4.add(sju2pcJT.group());
		}
		return WKJJmmR4;
	}

}