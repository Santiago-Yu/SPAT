class n7823490 {
	protected String getRequestContent(String ikX36ikb) throws Exception {
		URL ocxXmYxd = new URL(ikX36ikb);
		HttpURLConnection WMTyGNYy = (HttpURLConnection) ocxXmYxd.openConnection();
		String sxG9U0VB = null;
		try {
			WMTyGNYy.setUseCaches(false);
			WMTyGNYy.connect();
			BufferedReader bSUAveEu = new BufferedReader(new InputStreamReader(WMTyGNYy.getInputStream()));
			sxG9U0VB = bSUAveEu.readLine();
			bSUAveEu.close();
		} finally {
			WMTyGNYy.disconnect();
		}
		return sxG9U0VB;
	}

}