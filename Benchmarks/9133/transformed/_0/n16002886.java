class n16002886 {
	public static InputStream getInputStream(String PywUZ5mt) throws java.io.IOException {
		URL lr8NRIGf = getURL(PywUZ5mt);
		if (lr8NRIGf != null) {
			return lr8NRIGf.openStream();
		}
		throw new FileNotFoundException("UniverseData: Resource \"" + PywUZ5mt + "\" not found.");
	}

}