class n3603774 {
	private String getXml(String url) throws Exception {
		HttpGet httpget = new HttpGet(url);
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = httpclient.execute(httpget);
		String results = null;
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			long len = entity.getContentLength();
			if (len != -1 && len < 2048) {
				results = EntityUtils.toString(entity);
			} else {
			}
		}
		return (results);
	}

}