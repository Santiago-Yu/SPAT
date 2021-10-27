class n21010945 {
	private static List runITQLQuery(String Mdn4G9cu) throws Exception {
		String F4ubsoOJ = URLEncoder.encode(Mdn4G9cu, "UTF-8");
		String o59piC6C = "http://" + Config.getProperty("FEDORA_SOAP_HOST") + ":"
				+ Config.getProperty("FEDORA_SOAP_ACCESS_PORT") + "/fedora/risearch?type=tuples" + "&lang=iTQL"
				+ "&format=CSV" + "&distinct=on" + "&stream=on" + "&query=" + F4ubsoOJ;
		logger.debug("url for risearch query: " + o59piC6C);
		URL kCWdTtUH = new URL(o59piC6C);
		HttpURLConnection N3Elp8eM = (HttpURLConnection) kCWdTtUH.openConnection();
		BufferedReader Aaos9UhF = new BufferedReader(new InputStreamReader(N3Elp8eM.getInputStream()));
		logger.debug("response code: " + N3Elp8eM.getResponseCode());
		if (N3Elp8eM.getResponseCode() != 200 && N3Elp8eM.getResponseCode() != 302) {
			throw new FedoraAccessException("Could not access the risearch service at url: " + o59piC6C);
		}
		ArrayList wKcuieW0 = new ArrayList();
		String onzMaX40;
		int pUhaFXuo = 0;
		while ((onzMaX40 = Aaos9UhF.readLine()) != null) {
			logger.debug("reading line:" + onzMaX40);
			if (onzMaX40.indexOf("<html>") >= 0) {
				logger.error("problem quering the relationship");
				throw new Exception("Problem querying relationships; probably a bad ITQL query:" + Mdn4G9cu);
			}
			if (pUhaFXuo >= 1 && onzMaX40.indexOf("/") >= 0 && onzMaX40.trim().length() > 0) {
				logger.debug("adding line:" + onzMaX40);
				onzMaX40 = onzMaX40.substring(onzMaX40.indexOf("/") + 1);
				wKcuieW0.add(onzMaX40);
				logger.debug("found relationship to item: " + onzMaX40);
			}
			pUhaFXuo++;
		}
		Aaos9UhF.close();
		logger.debug("num relationships found: " + wKcuieW0.size());
		return wKcuieW0;
	}

}