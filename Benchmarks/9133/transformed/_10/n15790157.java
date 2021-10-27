class n15790157 {
	public String runRawSearch(final String search) throws IOException {
		StringBuilder urlString = new StringBuilder("http://ajax.googleapis.com/ajax/services/search/web?");
		if (search == null) {
			return null;
		}
		if (version != null) {
			urlString.append("v=");
			urlString.append(version);
			urlString.append("&");
		}
		urlString.append("q=");
		urlString.append(StringEscapeUtils.escapeHtml(search));
		Proxy proxy = null;
		URL url = new URL(urlString.toString());
		final URLConnection connection;
		if (proxy != null) {
			connection = url.openConnection(proxy);
		} else {
			connection = url.openConnection();
		}
		String line;
		if (referer != null) {
			connection.addRequestProperty("Referer", referer);
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder builder = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		return builder.toString();
	}

}