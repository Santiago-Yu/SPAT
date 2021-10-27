class n16646632 {
	public static BufferedReader getReader(int license) {
		URL url = getResource(license);
		InputStream inStream;
		if (url == null)
			return null;
		try {
			inStream = url.openStream();
		} catch (IOException e) {
			return null;
		}
		return new BufferedReader(new InputStreamReader(inStream));
	}

}