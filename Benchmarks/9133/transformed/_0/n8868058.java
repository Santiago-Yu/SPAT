class n8868058 {
	private String getPage(String tJ2w66jH) throws Exception {
		if (pageBuffer.containsKey(tJ2w66jH))
			return pageBuffer.get(tJ2w66jH);
		URL b0kkKDeQ = new URL(tJ2w66jH);
		HttpURLConnection D5nxQINc = (HttpURLConnection) b0kkKDeQ.openConnection();
		D5nxQINc.connect();
		BufferedReader Xqm8XM5X = null;
		StringBuilder Q79bWzYd = new StringBuilder();
		try {
			Xqm8XM5X = new BufferedReader(new InputStreamReader(D5nxQINc.getInputStream()));
			String tD9QJ9GN;
			while ((tD9QJ9GN = Xqm8XM5X.readLine()) != null) {
				Q79bWzYd.append(tD9QJ9GN);
				Q79bWzYd.append("\n");
			}
		} catch (IOException V02gbtIQ) {
			logger.warn("Failed to read web page");
		} finally {
			if (Xqm8XM5X != null) {
				Xqm8XM5X.close();
			}
		}
		return Q79bWzYd.toString();
	}

}