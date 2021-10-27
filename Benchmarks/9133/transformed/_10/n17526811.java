class n17526811 {
	private String getDocumentAsString(URL url) throws IOException {
		InputStream in = url.openStream();
		StringBuffer result = new StringBuffer();
		int c;
		while ((c = in.read()) != -1)
			result.append((char) c);
		return result.toString();
	}

}