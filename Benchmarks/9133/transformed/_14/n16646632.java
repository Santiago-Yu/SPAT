class n16646632 {
	public static BufferedReader getReader(int license) {
		URL url = getResource(license);
		if (null == url)
			return null;
		InputStream inStream;
		try {
			inStream = url.openStream();
		} catch (IOException e) {
			return null;
		}
		return new BufferedReader(new InputStreamReader(inStream));
	}

}