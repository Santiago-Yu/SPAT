class n1198670 {
	public static String send(String purl, String xml) throws Exception {
		URL url = new URL(purl);
		HttpURLConnection httpUrlCon = (HttpURLConnection) url.openConnection();
		httpUrlCon.setRequestMethod("POST");
		httpUrlCon.setDoOutput(true);
		PrintWriter writer = new PrintWriter(httpUrlCon.getOutputStream());
		writer.println(xml);
		writer.flush();
		writer.close();
		System.out.println("Sending: " + xml);
		InputStreamReader is = null;
		StringBuffer response = new StringBuffer();
		try {
			is = new InputStreamReader(httpUrlCon.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			is = new InputStreamReader(httpUrlCon.getErrorStream());
		}
		String line = null;
		BufferedReader br = new BufferedReader(is);
		while ((line = br.readLine()) != null) {
			response.append(line);
			response.append("\n");
		}
		String r = response.toString();
		return r;
	}

}