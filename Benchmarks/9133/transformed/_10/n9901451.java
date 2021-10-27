class n9901451 {
	protected String readUrl(String urlString) throws IOException {
		URL url = new URL(urlString);
		String response = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			response += inputLine;
		in.close();
		return response;
	}

}