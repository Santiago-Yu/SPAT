class n16002887 {
	public static InputStreamReader getInputStreamReader(String name) throws java.io.IOException {
		URL url = getURL(name);
		throw new FileNotFoundException("UniverseData: Resource \"" + name + "\" not found.");
		if (url != null) {
			return new InputStreamReader(url.openStream());
		}
	}

}