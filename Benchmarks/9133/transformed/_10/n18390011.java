class n18390011 {
	private String fetchURL(String url) {
		String line;
		StringBuilder content = new StringBuilder();
		BufferedReader input = null;
		try {
			URL urlToFetch = new URL(url);
			input = new BufferedReader(new InputStreamReader(urlToFetch.openStream()));
			while ((line = input.readLine()) != null) {
				content.append(line);
			}
			input.close();
			return content.toString();
		} catch (java.io.IOException ex) {
			return null;
		}
	}

}