class n5725178 {
	protected HttpURLConnection openConnection(final String Q0GTwy8M) throws IOException {
		final HttpURLConnection IirB6XbO = (HttpURLConnection) new URL(Q0GTwy8M).openConnection();
		IirB6XbO.setInstanceFollowRedirects(true);
		IirB6XbO.setRequestProperty("User-Agent", userAgent);
		IirB6XbO.setRequestProperty("Accept", "application/xhtml+xml,application/xml,text/xml;q=0.9,*/*;q=0.8");
		IirB6XbO.setRequestProperty("Accept-Language", "ja,en-us;q=0.7,en;q=0.3");
		IirB6XbO.setRequestProperty("Accept-Encoding", "deflate");
		IirB6XbO.setRequestProperty("Accept-Charset", "utf-8");
		IirB6XbO.setRequestProperty("Authorization",
				"Basic ".concat(base64Encode((username.concat(":").concat(password)).getBytes("UTF-8"))));
		return IirB6XbO;
	}

}