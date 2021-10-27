class n7093301 {
	public static InputStream executePost(String path, Map<String, String> params) throws Exception {
		HttpPost httpPost = new HttpPost(path);
		List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> param : params.entrySet()) {
			postParams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
		}
		HttpEntity entity = new UrlEncodedFormEntity(postParams, "UTF-8");
		httpPost.setEntity(entity);

		HttpResponse httpResponse = sClient.execute(httpPost);
		if (HttpStatus.SC_OK == httpResponse.getStatusLine().getStatusCode()) {
			return httpResponse.getEntity().getContent();
		} else {
			return null;
		}
	}

}