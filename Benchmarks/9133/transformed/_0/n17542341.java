class n17542341 {
	public GEItem lookup(final String MNMDzIt2) {
		try {
			URL b04KCkqK = new URL(
					GrandExchange.HOST + "/m=itemdb_rs/results.ws?query=" + MNMDzIt2 + "&price=all&members=");
			BufferedReader niA3q84k = new BufferedReader(new InputStreamReader(b04KCkqK.openStream()));
			String vduhWK6z;
			while ((vduhWK6z = niA3q84k.readLine()) != null) {
				if (vduhWK6z.contains("<div id=\"search_results_text\">")) {
					vduhWK6z = niA3q84k.readLine();
					if (vduhWK6z.contains("Your search for")) {
						return null;
					}
				} else if (vduhWK6z.startsWith("<td><img src=")) {
					Matcher JIWKx1a7 = GrandExchange.PATTERN.matcher(vduhWK6z);
					if (JIWKx1a7.find()) {
						if (JIWKx1a7.group(2).contains(MNMDzIt2)) {
							return lookup(Integer.parseInt(JIWKx1a7.group(1)));
						}
					}
				}
			}
		} catch (IOException uY4SKlYA) {
		}
		return null;
	}

}