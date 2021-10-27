class n20150442 {
	public String accessURL_Post(String url, Map<String, String> keyValue, String encoding) throws Throwable {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		for (String key : keyValue.keySet()) {
			formparams.add(new BasicNameValuePair(key, keyValue.get(key)));
		}
		HttpPost httpPost = new HttpPost(url);
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, encoding);
		httpPost.setEntity(entity);
		HttpResponse response = client.execute(httpPost);
		String entuity = EntityUtils.toString(response.getEntity());
		handleHeaders(response.getAllHeaders());
		return entuity;
	}

}