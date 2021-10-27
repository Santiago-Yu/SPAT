class n22415294 {
	private String getRenderedBody(String spec) throws Exception {
		log.entering(Rss2MailTask.class.getName(), "getRenderedBody");
		final URL url = new URL(spec);
		final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		final InputStream inputStream = connection.getInputStream();
		String line = "";
		final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		final StringBuffer bf = new StringBuffer();
		while (line != null) {
			line = reader.readLine();
			if (line != null) {
				bf.append(line);
			}
		}
		log.exiting(Rss2MailTask.class.getName(), "getRenderedBody");
		return bf.toString();
	}

}