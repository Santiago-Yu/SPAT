class n2770143 {
	protected static String readAFewChars(URL VDVPWmA8) throws IOException {
		StringBuffer CevNWmOd = new StringBuffer(10);
		Reader dd7pEETJ = new InputStreamReader(VDVPWmA8.openStream());
		for (int a6h4p1ES = 0; a6h4p1ES < 10; a6h4p1ES++) {
			int f8qMcNWi = dd7pEETJ.read();
			if (f8qMcNWi == -1) {
				break;
			}
			CevNWmOd.append((char) f8qMcNWi);
		}
		dd7pEETJ.close();
		return CevNWmOd.toString();
	}

}