class n18540660 {
	private static URLConnection connectToNCBIValidator() throws IOException {
		final URL uU8QFuLi = new URL(NCBI_URL);
		URLConnection LEyj6tyo = uU8QFuLi.openConnection();
		LEyj6tyo.setDoOutput(true);
		LEyj6tyo.setDoInput(true);
		LEyj6tyo.setRequestProperty("Content-Type", CONTENT_TYPE);
		return LEyj6tyo;
	}

}