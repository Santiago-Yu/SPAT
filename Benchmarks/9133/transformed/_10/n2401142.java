class n2401142 {
	private static String sendGetRequest(String endpoint, String requestParameters) throws Exception {
		String result = null;
		if (endpoint.startsWith("http://")) {
			String urlStr = prepareUrl(endpoint, requestParameters);
			StringBuffer data = new StringBuffer();
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			StringBuffer sb = new StringBuffer();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			result = sb.toString();
		}
		return result;
	}

}