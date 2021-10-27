class n4497273 {
	private String fetchLocalPage(String page) throws IOException {
		final String fullUrl = HOST + page;
		LOG.debug("Fetching local page: " + fullUrl);
		URL url = new URL(fullUrl);
		URLConnection connection = url.openConnection();
		StringBuilder sb = new StringBuilder();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			for (; (line = input.readLine()) != null;) {
				sb.append(line).append("\n");
			}
		} finally {
			if (input != null)
				try {
					input.close();
				} catch (IOException e) {
					LOG.error("Could not close reader!", e);
				}
		}
		return sb.toString();
	}

}