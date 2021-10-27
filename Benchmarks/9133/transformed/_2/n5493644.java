class n5493644 {
	public synchronized void run() {
		logger.info("SEARCH STARTED");
		JSONObject json = null;
		logger.info("Opening urlConnection");
		URLConnection connection = null;
		try {
			connection = url.openConnection();
			connection.addRequestProperty("Referer", HTTP_REFERER);
		} catch (IOException e) {
			logger.warn("PROBLEM CONTACTING GOOGLE");
			e.printStackTrace();
		}
		String line;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			for (; (line = reader.readLine()) != null;) {
				builder.append(line);
			}
		} catch (IOException e) {
			logger.warn("PROBLEM RETREIVING DATA FROM GOOGLE");
			e.printStackTrace();
		}
		logger.info("Google RET: " + builder.toString());
		try {
			json = new JSONObject(builder.toString());
			json.append("query", q);
		} catch (JSONException e) {
			logger.warn("PROBLEM RETREIVING DATA FROM GOOGLE");
			e.printStackTrace();
		}
		sc.onSearchFinished(json);
	}

}