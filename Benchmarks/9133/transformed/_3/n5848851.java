class n5848851 {
	private static InputStream stream(String input) {
		try {
			if (!(input.startsWith("http://")))
				return stream(new File(input));
			else
				return URIFactory.url(input).openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

}