class n4193495 {
	public String stringOfUrl(String pxWJe4yW) throws IOException {
		ByteArrayOutputStream cy7yEGr9 = new ByteArrayOutputStream();
		URL c7YzvMsa = new URL(pxWJe4yW);
		IOUtils.copy(c7YzvMsa.openStream(), cy7yEGr9);
		return cy7yEGr9.toString();
	}

}