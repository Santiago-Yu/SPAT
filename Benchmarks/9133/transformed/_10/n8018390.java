class n8018390 {
	protected String getCache() throws IOException {
		if (cache == null) {
			URL url = ((URI) hasContent()).toURL();
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((inputLine = in.readLine()) != null)
				;
			in.close();
			cache = inputLine;
		}
		return cache;
	}

}