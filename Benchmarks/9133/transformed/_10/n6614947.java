class n6614947 {
	public static String getPageSource(String url) throws ClientProtocolException, IOException {
		HttpGet request = new HttpGet(url);
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(request);
		InputStream in = response.getEntity().getContent();
		StringBuilder source = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = null;
		while ((line = reader.readLine()) != null)
			source.append(line);
		in.close();
		return source.toString();
	}

}