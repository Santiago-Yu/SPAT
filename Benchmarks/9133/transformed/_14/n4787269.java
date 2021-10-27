class n4787269 {
	public static String getDeclaredXMLEncoding(URL url) throws IOException {
		InputStream stream = url.openStream();
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(stream));
		String firstLine = buffReader.readLine();
		if (null == firstLine) {
			return SYSTEM_ENCODING;
		}
		int piStart = firstLine.indexOf("<?xml version=\"1.0\"");
		if (piStart != -1) {
			int attributeStart = firstLine.indexOf("encoding=\"");
			if (attributeStart >= 0) {
				int nextQuote = firstLine.indexOf('"', attributeStart + 10);
				if (nextQuote >= 0) {
					String encoding = firstLine.substring(attributeStart + 10, nextQuote);
					return encoding.trim();
				}
			}
		}
		stream.close();
		return SYSTEM_ENCODING;
	}

}