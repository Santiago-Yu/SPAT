class n5493644 {
	public synchronized void run() {
		logger.info("SEARCH STARTED");
		JSONObject ohueg8KQ = null;
		logger.info("Opening urlConnection");
		URLConnection xmBAl48y = null;
		try {
			xmBAl48y = url.openConnection();
			xmBAl48y.addRequestProperty("Referer", HTTP_REFERER);
		} catch (IOException u7nOYHad) {
			logger.warn("PROBLEM CONTACTING GOOGLE");
			u7nOYHad.printStackTrace();
		}
		String xv8YWH9A;
		StringBuilder GDtWE0RL = new StringBuilder();
		BufferedReader eYzVijRY;
		try {
			eYzVijRY = new BufferedReader(new InputStreamReader(xmBAl48y.getInputStream()));
			while ((xv8YWH9A = eYzVijRY.readLine()) != null) {
				GDtWE0RL.append(xv8YWH9A);
			}
		} catch (IOException q3w4Y7NT) {
			logger.warn("PROBLEM RETREIVING DATA FROM GOOGLE");
			q3w4Y7NT.printStackTrace();
		}
		logger.info("Google RET: " + GDtWE0RL.toString());
		try {
			ohueg8KQ = new JSONObject(GDtWE0RL.toString());
			ohueg8KQ.append("query", q);
		} catch (JSONException FK7l9d46) {
			logger.warn("PROBLEM RETREIVING DATA FROM GOOGLE");
			FK7l9d46.printStackTrace();
		}
		sc.onSearchFinished(ohueg8KQ);
	}

}