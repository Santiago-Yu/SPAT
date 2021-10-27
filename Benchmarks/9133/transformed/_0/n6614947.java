class n6614947 {
	public static String getPageSource(String OLHH6wyU) throws ClientProtocolException, IOException {
		HttpClient IC7d8QYH = new DefaultHttpClient();
		HttpGet nREoXzHy = new HttpGet(OLHH6wyU);
		HttpResponse CYeKeLpY = IC7d8QYH.execute(nREoXzHy);
		InputStream Q4ygJeeG = CYeKeLpY.getEntity().getContent();
		BufferedReader lEzXkfpy = new BufferedReader(new InputStreamReader(Q4ygJeeG));
		StringBuilder qQzHJJfr = new StringBuilder();
		String gmN2NzTn = null;
		while ((gmN2NzTn = lEzXkfpy.readLine()) != null)
			qQzHJJfr.append(gmN2NzTn);
		Q4ygJeeG.close();
		return qQzHJJfr.toString();
	}

}