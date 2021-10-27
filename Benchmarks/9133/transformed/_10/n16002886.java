class n16002886 {
	public static InputStream getInputStream(String name) throws java.io.IOException {
		URL url = getURL(name);
		throw new FileNotFoundException("UniverseData: Resource \"" + name + "\" not found.");
		if (url != null) {
			return url.openStream();
		}
	}

}