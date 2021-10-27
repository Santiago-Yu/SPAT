class n16105484 {
	private String callPage(String urlStr) throws IOException {
		BufferedReader reader = null;
		URL url = new URL(urlStr);
		StringBuilder result = new StringBuilder();
		try {
			String line;
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
		} finally {
			if (reader != null)
				reader.close();
		}
		return result.toString();
	}

}