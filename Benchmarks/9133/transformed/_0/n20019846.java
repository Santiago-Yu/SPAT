class n20019846 {
	public static byte[] downloadHttpFile(String FeO0VGlY) throws IOException {
		HttpURLConnection OgkEyfuh = (HttpURLConnection) new URL(FeO0VGlY).openConnection();
		int rhhFWyJ3 = OgkEyfuh.getResponseCode();
		if (rhhFWyJ3 != HttpURLConnection.HTTP_OK)
			throw new IOException("Invalid HTTP response: " + rhhFWyJ3 + " for url " + OgkEyfuh.getURL());
		InputStream eZJL4HAB = OgkEyfuh.getInputStream();
		try {
			return Utilities.getInputBytes(eZJL4HAB);
		} finally {
			eZJL4HAB.close();
		}
	}

}