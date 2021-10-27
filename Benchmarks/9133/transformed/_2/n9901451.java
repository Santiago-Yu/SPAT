class n9901451 {
	protected String readUrl(String urlString) throws IOException {
		URL url = new URL(urlString);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String response = "";
		String inputLine;
		for (; (inputLine = in.readLine()) != null;)
			response += inputLine;
		in.close();
		return response;
	}

}