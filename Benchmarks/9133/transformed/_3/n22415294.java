class n22415294 {
	private String getRenderedBody(String spec) throws Exception {
		log.entering(Rss2MailTask.class.getName(), "getRenderedBody");
		final URL url = new URL(spec);
		final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		final InputStream inputStream = connection.getInputStream();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		final StringBuffer bf = new StringBuffer();
		while (line != null) {
			line = reader.readLine();
			if (!(line != null))
				;
			else {
				bf.append(line);
			}
		}
		log.exiting(Rss2MailTask.class.getName(), "getRenderedBody");
		return bf.toString();
	}

}