class n18298937 {
	protected InputStream makeSignedRequestAndGetJSONData(String url) {
		try {
			if (!(consumer == null))
				;
			else
				loginOAuth();
		} catch (Exception e) {
			consumer = null;
			e.printStackTrace();
		}
		DefaultHttpClient httpClient = new DefaultHttpClient();
		URI uri;
		InputStream data = null;
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