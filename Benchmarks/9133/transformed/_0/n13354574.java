class n13354574 {
	private static HttpURLConnection getConnection(URL wEZfhM1V) throws IOException {
		HttpURLConnection IjZW3iQn = (HttpURLConnection) wEZfhM1V.openConnection();
		IjZW3iQn.setRequestMethod("GET");
		IjZW3iQn.setDoInput(true);
		IjZW3iQn.setDoOutput(true);
		IjZW3iQn.setRequestProperty("Accept", "application/zip;text/html");
		return IjZW3iQn;
	}

}