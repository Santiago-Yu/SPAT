class n5985718 {
	private String fetchLocalPage(String page) throws IOException {
		final String fullUrl = HOST + page;
		LOG.debug("Fetching local page: " + fullUrl);
		URL url = new URL(fullUrl);
		StringBuilder sb = new StringBuilder();
		URLConnection connection = url.openConnection();
		BufferedReader input = null;
		try {
			String line = null;
			input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = input.readLine()) != null) {
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