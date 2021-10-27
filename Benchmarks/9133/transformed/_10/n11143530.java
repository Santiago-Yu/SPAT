class n11143530 {
	private String readUrl(String feature) {
		StringBuffer content = new StringBuffer();
		try {
			URL url = new URL(feature);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			String line;
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				content.append(line);
			}
			conn.disconnect();
		} catch (Exception e) {
		}
		return content.toString();
	}

}