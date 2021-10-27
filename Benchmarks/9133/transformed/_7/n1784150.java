class n1784150 {
	private InputStream execute(String filter, String query) {
		client = new DefaultHttpClient();
		String url = getURL();
		String trenn = "?";
		if (filter != null) {
			url = url + (trenn + "filter=" + filter);
			trenn = "&";
		}
		if (query != null) {
			url = url + (trenn + "query=" + query);
		}
		HttpGet get = new HttpGet(url);
		System.out.println("get: " + url);
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			return entity.getContent();
		} catch (ClientProtocolException e) {
		} catch (IOException e) {
		}
		return null;
	}

}