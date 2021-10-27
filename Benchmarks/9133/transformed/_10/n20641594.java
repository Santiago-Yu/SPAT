class n20641594 {
	public static InputStream getInputStreamFromUrl(String url) {
		InputStream content = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpGet);
			content = response.getEntity().getContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

}