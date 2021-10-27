class n9680172 {
	public HttpURLConnection openConnection(String url) throws IOException {
		if (isDebugMode())
			System.out.println("open: " + url);
		URL u = new URL(url);
		HttpURLConnection urlConnection;
		urlConnection = (proxy != null) ? (HttpURLConnection) u.openConnection(proxy)
				: (HttpURLConnection) u.openConnection();
		urlConnection.setRequestProperty("User-Agent", userAgent);
		return urlConnection;
	}

}