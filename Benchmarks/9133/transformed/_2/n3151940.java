class n3151940 {
	String readRss(URL url) {
		String html = "<html><body><h2>No data</h2></body></html>";
		try {
			mLogger.info("URL is:" + url.toString());
			BufferedReader inStream = new BufferedReader(new InputStreamReader(url.openStream()), 1024);
			String line;
			StringBuilder rssFeed = new StringBuilder();
			for (; (line = inStream.readLine()) != null;) {
				rssFeed.append(line);
			}
			html = rssFeed.toString();
		} catch (IOException ex) {
			mLogger.warning("Couldn't open an RSS stream");
		}
		return html;
	}

}