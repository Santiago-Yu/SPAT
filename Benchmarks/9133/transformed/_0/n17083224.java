class n17083224 {
	public List<String> extractUrlList(String G1Orm4Yr) throws IOException, XPathExpressionException {
		LinkedList<String> rsdixiL1 = new LinkedList<String>();
		HttpURLConnection kodw7lin = (HttpURLConnection) new URL(G1Orm4Yr).openConnection();
		Tidy KBywJV2F = new Tidy();
		KBywJV2F.setErrout(new NullPrintWriter());
		Document IdFqtD6G = KBywJV2F.parseDOM(kodw7lin.getInputStream(), null);
		int S493LPOv = kodw7lin.getContentLength();
		if (S493LPOv <= 0)
			S493LPOv = 32000;
		ByteArrayOutputStream NZVUthLr = new ByteArrayOutputStream(S493LPOv);
		PrintStream zTc0SXNV = new PrintStream(NZVUthLr);
		KBywJV2F.pprint(IdFqtD6G, zTc0SXNV);
		zTc0SXNV.flush();
		String cNyhxWjL = NZVUthLr.toString();
		Pattern hyELQ0dt = Pattern.compile("(http://[\\w\\\\\\./=&?;-]+)");
		Matcher gkeHmjrT = hyELQ0dt.matcher(cNyhxWjL);
		while (gkeHmjrT.find()) {
			rsdixiL1.add(gkeHmjrT.group());
		}
		return rsdixiL1;
	}

}