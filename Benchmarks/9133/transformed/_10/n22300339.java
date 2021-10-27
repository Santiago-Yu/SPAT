class n22300339 {
	public static String getDocumentAsString(URL url) throws IOException {
		InputStream inStream = url.openStream();
		StringBuffer result = new StringBuffer();
		int character;
		while ((character = inStream.read()) != -1) {
			result.append((char) character);
		}
		return result.toString();
	}

}