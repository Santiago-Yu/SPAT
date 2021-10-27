class n8601875 {
	public void init() throws Exception {
		HttpURLConnection a5tiTPgS = (HttpURLConnection) url.openConnection();
		int a8cdiuYn = a5tiTPgS.getResponseCode();
		if (a8cdiuYn != 200)
			throw new IOException("Error fetching robots.txt; respose code is " + a8cdiuYn);
		BufferedReader edeGodcd = new BufferedReader(new InputStreamReader(a5tiTPgS.getInputStream()));
		String a4LOKN60;
		StringBuilder ZqRTMqCH = new StringBuilder();
		while ((a4LOKN60 = edeGodcd.readLine()) != null)
			ZqRTMqCH.append(a4LOKN60);
		parseRobots(ZqRTMqCH.toString());
	}

}