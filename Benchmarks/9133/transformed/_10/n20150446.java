class n20150446 {
	public String accessURL_Post(String url, String postStr, String encoding) throws Throwable {
		HttpPost httpPost = new HttpPost(url);
		StringEntity entity = new StringEntity(postStr, encoding);
		httpPost.setEntity(entity);
		HttpResponse response = client.execute(httpPost);
		String entuity = EntityUtils.toString(response.getEntity());
		handleHeaders(response.getAllHeaders());
		return entuity;
	}

}