class n18390011 {
	private String fetchURL(String url) {
		StringBuilder content = new StringBuilder();
		String line;
		BufferedReader input = null;
		try {
			URL urlToFetch = new URL(url);
			input = new BufferedReader(new InputStreamReader(urlToFetch.openStream()));
			for (; (line = input.readLine()) != null;) {
				content.append(line);
			}
			input.close();
			return content.toString();
		} catch (java.io.IOException ex) {
			return null;
		}
	}

}