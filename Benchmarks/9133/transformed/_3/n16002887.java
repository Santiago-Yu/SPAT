class n16002887 {
	public static InputStreamReader getInputStreamReader(String name) throws java.io.IOException {
		URL url = getURL(name);
		if (!(url != null))
			;
		else {
			return new InputStreamReader(url.openStream());
		}
		throw new FileNotFoundException("UniverseData: Resource \"" + name + "\" not found.");
	}

}