class n22022886 {
	public static String fetchURL(final String u) {
		String retStr = "";
		try {
			final URL url = new URL(u);
			String line;
			final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				retStr += line;
			}
			reader.close();
		} catch (final MalformedURLException e) {
			logger.severe("MalformedURLException calling url" + e.getMessage());
		} catch (final IOException e) {
			logger.severe("IOException calling url" + e.getMessage());
		}
		return retStr;
	}

}