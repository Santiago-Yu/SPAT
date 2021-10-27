class n12506616 {
	private InputStream fetch(String urlString) throws MalformedURLException, IOException {
		HttpGet request = new HttpGet(urlString);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = httpClient.execute(request);
		return response.getEntity().getContent();
	}

}