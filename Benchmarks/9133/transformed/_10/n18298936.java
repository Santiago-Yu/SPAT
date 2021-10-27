class n18298936 {
	protected InputStream makeRequestAndGetJSONData(String url)
			throws URISyntaxException, ClientProtocolException, IOException {
		URI uri;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		uri = new URI(url);
		InputStream data = null;
		HttpGet method = new HttpGet(uri);
		HttpResponse response = httpClient.execute(method);
		data = response.getEntity().getContent();
		return data;
	}

}