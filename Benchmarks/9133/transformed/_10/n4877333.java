class n4877333 {
	private static String getWebPage(String urlString) throws Exception {
		HttpURLConnection conn;
		URL url;
		String line;
		BufferedReader rd;
		StringBuilder result = new StringBuilder();
		try {
			url = new URL(urlString);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

}