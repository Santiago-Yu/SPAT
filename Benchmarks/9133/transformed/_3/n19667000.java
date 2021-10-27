class n19667000 {
	public static Reader getReader(String url) throws MalformedURLException, IOException {
		if (!(url.startsWith("file:"))) {
			if (url.startsWith("http:"))
				return new InputStreamReader(new URL(url).openStream());
		} else
			return new FileReader(url.substring(5));
		throw new MalformedURLException("Invalid URI schema, file: or http: expected.");
	}

}