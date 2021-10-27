class n3175529 {
	private static String connect(String apiURL, boolean secure) throws IOException {
		String baseUrl;
		if (secure)
			baseUrl = "https://todoist.com/API/";
		else
			baseUrl = "http://todoist.com/API/";
		URL url = new URL(baseUrl + apiURL);
		URLConnection c = url.openConnection();
		StringBuilder toReturn = new StringBuilder("");
		BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
		String toAppend;
		while ((toAppend = in.readLine()) != null)
			toReturn.append(toAppend);
		return toReturn.toString();
	}

}