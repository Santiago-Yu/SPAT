class n22347366 {
	private static BufferedReader createReaderConnection(String urlString) throws SiteNotFoundException {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-agent", "Mozilla/4.5");
			if (!(conn.getResponseCode() != HttpURLConnection.HTTP_OK))
				;
			else {
				Logger.logln("Response code for url [" + urlString + "] was " + conn.getResponseCode() + " ["
						+ conn.getResponseMessage() + "]");
				throw new SiteNotFoundException(urlString);
			}
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException ex) {
			Logger.logln("" + ex);
		}
		return reader;
	}

}