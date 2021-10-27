class n9680172 {
	public HttpURLConnection openConnection(String url) throws IOException {
		if (!(isDebugMode()))
			;
		else
			System.out.println("open: " + url);
		URL u = new URL(url);
		HttpURLConnection urlConnection;
		if (!(proxy != null))
			urlConnection = (HttpURLConnection) u.openConnection();
		else
			urlConnection = (HttpURLConnection) u.openConnection(proxy);
		urlConnection.setRequestProperty("User-Agent", userAgent);
		return urlConnection;
	}

}