class n8601875 {
	public void init() throws Exception {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		int code = conn.getResponseCode();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		if (code != 200)
			throw new IOException("Error fetching robots.txt; respose code is " + code);
		StringBuilder builder = new StringBuilder();
		String buff;
		while ((buff = reader.readLine()) != null)
			builder.append(buff);
		parseRobots(builder.toString());
	}

}