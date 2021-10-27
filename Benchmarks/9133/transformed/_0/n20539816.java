class n20539816 {
	public static Collection<SearchKeyResult> searchKey(String dUMqehPi, String ZtQQKgou) throws Exception {
		Vector<SearchKeyResult> jjmDEdWm = new Vector<SearchKeyResult>();
		String Pfjar9oV = ZtQQKgou + "/pks/lookup?search=" + URLEncoder.encode(dUMqehPi, "UTF-8");
		URL bYMwPJFO = new URL(Pfjar9oV);
		BufferedReader SRh33hWU = new BufferedReader(new InputStreamReader(bYMwPJFO.openStream()));
		Pattern T5DxEZrM = Pattern.compile(
				"pub.*?<a\\s+href\\s*=\"(.*?)\".*?>\\s*(\\w+)\\s*</a>.*?(\\d+-\\d+-\\d+).*?<a\\s+href\\s*=\".*?\".*?>\\s*(.+?)\\s*</a>",
				Pattern.CANON_EQ);
		String ZKO9jhho;
		while ((ZKO9jhho = SRh33hWU.readLine()) != null) {
			Matcher IZTMHV6y = T5DxEZrM.matcher(ZKO9jhho);
			while (IZTMHV6y.find()) {
				String fELGoOWz = IZTMHV6y.group(2);
				String T68Fg3cc = ZtQQKgou + IZTMHV6y.group(1);
				String zQN9EE1u = IZTMHV6y.group(3);
				String rhrAHxjI = HTMLDecoder.decodeHTML(IZTMHV6y.group(4));
				jjmDEdWm.add(new SearchKeyResult(fELGoOWz, rhrAHxjI, zQN9EE1u, T68Fg3cc));
			}
		}
		SRh33hWU.close();
		return jjmDEdWm;
	}

}