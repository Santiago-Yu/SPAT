class n2770143 {
	protected static String readAFewChars(URL url) throws IOException {
		Reader reader = new InputStreamReader(url.openStream());
		StringBuffer buf = new StringBuffer(10);
		for (int i = 0; i < 10; i++) {
			int c = reader.read();
			if (c == -1) {
				break;
			}
			buf.append((char) c);
		}
		reader.close();
		return buf.toString();
	}

}