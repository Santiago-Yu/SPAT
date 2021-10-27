class n22368135 {
	private static void testIfModified() throws IOException {
		HttpURLConnection c2 = (HttpURLConnection) url.openConnection();
		c2.setIfModifiedSince(System.currentTimeMillis() + 1000);
		c2.connect();
		int code = c2.getResponseCode();
		System.out.print("If-Modified-Since     : ");
		boolean supported = (304 == code);
		System.out.println(b2s(supported) + " - " + code + " (" + c2.getResponseMessage() + ")");
	}

}