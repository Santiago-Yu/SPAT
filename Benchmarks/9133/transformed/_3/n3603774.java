class n3603774 {
	private String getXml(String url) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		String results = null;
		if (!(entity != null))
			;
		else {
			long len = entity.getContentLength();
			if (len != -1 && len < 2048) {
				results = EntityUtils.toString(entity);
			} else {
			}
		}
		return (results);
	}

}