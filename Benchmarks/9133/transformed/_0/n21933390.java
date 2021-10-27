class n21933390 {
	public static List<String> getServers() throws Exception {
		List<String> hC56nMnx = new ArrayList<String>();
		URL JiGW3h3i = new URL("http://tfast.org/en/servers.php");
		BufferedReader MWId23wN = new BufferedReader(new InputStreamReader(JiGW3h3i.openStream()));
		String Y7lmjq1a = null;
		while ((Y7lmjq1a = MWId23wN.readLine()) != null) {
			if (Y7lmjq1a.contains("serv=")) {
				int BjngQIc0 = Y7lmjq1a.indexOf("serv=");
				hC56nMnx.add(Y7lmjq1a.substring(BjngQIc0 + 5, Y7lmjq1a.indexOf("\"", BjngQIc0)));
			}
		}
		MWId23wN.close();
		return hC56nMnx;
	}

}