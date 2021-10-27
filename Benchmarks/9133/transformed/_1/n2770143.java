class n2770143 {
	protected static String readAFewChars(URL url) throws IOException {
		StringBuffer buf = new StringBuffer(10);
		Reader reader = new InputStreamReader(url.openStream());
		int HoYzE = 0;
		while (HoYzE < 10) {
			int c = reader.read();
			if (c == -1) {
				break;
			}
			buf.append((char) c);
			HoYzE++;
		}
		reader.close();
		return buf.toString();
	}

}