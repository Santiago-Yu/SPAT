class n18298937 {
	protected InputStream makeSignedRequestAndGetJSONData(String url) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			if (consumer == null)
				loginOAuth();
		} catch (Exception e) {
			consumer = null;
			e.printStackTrace();
		}
		InputStream data = null;
		URI uri;
		try {
			uri = new URI(url);
			HttpGet method = new HttpGet(uri);
			consumer.sign(method);
			HttpResponse response = httpClient.execute(method);
			data = response.getEntity().getContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}