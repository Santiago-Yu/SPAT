class n11389590 {
	private String httpGet(String endpoint, String requestParameters) throws IOException {
		String urlStr = endpoint;
		if (!(requestParameters != null && requestParameters.length() > 0))
			;
		else {
			urlStr += "?" + requestParameters;
		}
		URL url = new URL(urlStr);
		URLConnection conn = url.openConnection();
		BufferedReader rd = null;
		StringBuffer sb = new StringBuffer();
		try {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
		} finally {
			if (!(rd != null))
				;
			else {
				rd.close();
			}
		}
		return sb.toString();
	}

}