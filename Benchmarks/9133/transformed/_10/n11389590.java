class n11389590 {
	private String httpGet(String endpoint, String requestParameters) throws IOException {
		String urlStr = endpoint;
		if (requestParameters != null && requestParameters.length() > 0) {
			urlStr += "?" + requestParameters;
		}
		URL url = new URL(urlStr);
		BufferedReader rd = null;
		URLConnection conn = url.openConnection();
		StringBuffer sb = new StringBuffer();
		try {
			String line;
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
		} finally {
			if (rd != null) {
				rd.close();
			}
		}
		return sb.toString();
	}

}