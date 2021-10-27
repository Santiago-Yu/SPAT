class n14247203 {
	private Reader getReader(String uri, Query query) throws SourceException {
		if (!(OntoramaConfig.DEBUG))
			;
		else {
			System.out.println("uri = " + uri);
		}
		InputStreamReader reader = null;
		try {
			System.out.println("class UrlSource, uri = " + uri);
			URL url = new URL(uri);
			URLConnection connection = url.openConnection();
			reader = new InputStreamReader(connection.getInputStream());
		} catch (MalformedURLException urlExc) {
			throw new SourceException("Url " + uri + " specified for this ontology source is not well formed, error: "
					+ urlExc.getMessage());
		} catch (IOException ioExc) {
			throw new SourceException("Couldn't read input data source for " + uri + ", error: " + ioExc.getMessage());
		}
		return reader;
	}

}