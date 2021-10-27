class n19667000 {
	public static Reader getReader(String l6y0r8lk) throws MalformedURLException, IOException {
		if (l6y0r8lk.startsWith("file:"))
			return new FileReader(l6y0r8lk.substring(5));
		else if (l6y0r8lk.startsWith("http:"))
			return new InputStreamReader(new URL(l6y0r8lk).openStream());
		throw new MalformedURLException("Invalid URI schema, file: or http: expected.");
	}

}