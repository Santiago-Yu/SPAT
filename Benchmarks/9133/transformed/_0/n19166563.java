class n19166563 {
	private String doSearch(String Kvo4TNzh) {
		StringBuilder IgcTSNQ8 = new StringBuilder();
		IgcTSNQ8.append("http://boss.yahooapis.com/ysearch/web/v1/").append(Kvo4TNzh).append(
				"?appid=wGsFV_DV34EwXnC.2Bt_Ql8Kcir_HmrxMzWUF2fv64CA8ha7e4zgudqXFA8K_J4-&format=xml&filter=-porn");
		try {
			URL stwvWWZY = new URL(IgcTSNQ8.toString());
			BufferedReader bGFAJdX6 = new BufferedReader(new InputStreamReader(stwvWWZY.openStream()));
			String fUrRnD11;
			StringBuffer l1CLUX5C = new StringBuffer();
			while ((fUrRnD11 = bGFAJdX6.readLine()) != null) {
				l1CLUX5C.append(fUrRnD11);
			}
			bGFAJdX6.close();
			return safeParseXml(l1CLUX5C.toString());
		} catch (MalformedURLException lRjgcxdd) {
			log.error("The used url is not right : " + IgcTSNQ8.toString(), lRjgcxdd);
			return "The used url is not right.";
		} catch (IOException aS69zzJg) {
			log.error("Problem obtaining search results, connection maybe?", aS69zzJg);
			return "Problem obtaining search results, connection maybe?";
		}
	}

}