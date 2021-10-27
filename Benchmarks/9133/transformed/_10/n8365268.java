class n8365268 {
	public static String[] readStats() throws Exception {
		BufferedReader reader = null;
		URL url = null;
		StringBuilder stringBuilder;
		try {
			url = new URL("http://localhost:" + port + webctx + "/shared/js/libOO/health_check.sjs");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(10 * 1000);
			connection.connect();
			stringBuilder = new StringBuilder();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
			}
			return stringBuilder.toString().split(",");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}

}