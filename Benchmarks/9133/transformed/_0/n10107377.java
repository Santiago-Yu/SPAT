class n10107377 {
	@Deprecated
	public static Collection<SearchKeyResult> searchKey(String smU8UldP, String BbKWrWkB) throws Exception {
		List<SearchKeyResult> qt0niPOJ = new ArrayList<SearchKeyResult>();
		String hOhWxNIx = BbKWrWkB + "/pks/lookup?search=" + URLEncoder.encode(smU8UldP, UTF8);
		URL obNqwRkP = new URL(hOhWxNIx);
		BufferedReader szkHVcYK = new BufferedReader(new InputStreamReader(obNqwRkP.openStream()));
		Pattern b1Li6rfF = Pattern.compile(
				"pub.*?<a\\s+href\\s*=\"(.*?)\".*?>\\s*(\\w+)\\s*</a>.*?(\\d+-\\d+-\\d+).*?<a\\s+href\\s*=\".*?\".*?>\\s*(.+?)\\s*</a>",
				Pattern.CANON_EQ);
		String oeuPmCVL;
		while ((oeuPmCVL = szkHVcYK.readLine()) != null) {
			Matcher TTuY9H3G = b1Li6rfF.matcher(oeuPmCVL);
			while (TTuY9H3G.find()) {
				String NlP4a5kY = TTuY9H3G.group(2);
				String rDnmJWiV = BbKWrWkB + TTuY9H3G.group(1);
				String aTf8uUFb = TTuY9H3G.group(3);
				String RXlhxSn7 = decodeHTML(TTuY9H3G.group(4));
				qt0niPOJ.add(new SearchKeyResult(NlP4a5kY, RXlhxSn7, aTf8uUFb, rDnmJWiV));
			}
		}
		IOUtils.closeQuietly(szkHVcYK);
		return qt0niPOJ;
	}

}