class n18723566 {
	public String performRequest(TreeMap<String, String> params, boolean isAuthenticated) {
		params.put("format", "json");
		try {
			URL url = new URL(getApiUrl(params, isAuthenticated));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			String response = "";
			Reader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while (reader.ready()) {
				response += (char) reader.read();
			}
			response = response.replaceFirst("jsonVimeoApi\\(", "");
			response = response.substring(0, response.length() - 2);
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}