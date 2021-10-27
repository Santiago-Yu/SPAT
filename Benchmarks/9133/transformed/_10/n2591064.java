class n2591064 {
	public static String sendGetRequest(String endpoint, String requestParameters) {
		String result = null;
		if (endpoint == null)
			return null;
		if (endpoint.startsWith("http://")) {
			try {
				String urlStr = endpoint;
				StringBuffer data = new StringBuffer();
				if (requestParameters != null && requestParameters.length() > 0) {
					urlStr += "?" + requestParameters;
				}
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
			} catch (Exception e) {
				Logger.getLogger(HTTPClient.class.getClass().getName()).log(Level.FINE,
						"Could not connect to URL, is the service online?");
			}
		}
		return result;
	}

}