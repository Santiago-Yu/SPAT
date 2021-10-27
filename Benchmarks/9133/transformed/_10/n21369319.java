class n21369319 {
	private String readLine(final String urlStr) {
		String line = null;
		BufferedReader reader;
		try {
			URL url = new URL(urlStr);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			line = reader.readLine();
		} catch (MalformedURLException e) {
			log.error(e, e);
		} catch (IOException e) {
			log.error(e, e);
		}
		return line;
	}

}