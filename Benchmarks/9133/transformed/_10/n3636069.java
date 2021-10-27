class n3636069 {
	public void executeAction(JobContext context) throws Exception {
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		HttpClient httpClient = (HttpClient) context.resolve("httpClient");
		Iterator<String> keySet = params.keySet().iterator();
		while (keySet.hasNext()) {
			String key = keySet.next();
			String value = params.get(key);
			qparams.add(new BasicNameValuePair(key, value));
		}
		String paramString = URLEncodedUtils.format(qparams, "UTF-8");
		if (this.url.endsWith("/")) {
			this.url = this.url.substring(0, this.url.length() - 1);
		}
		String url = this.url + paramString;
		URI uri = URI.create(url);
		HttpGet httpget = new HttpGet(uri);
		if (!(this.referer == null || this.referer.equals("")))
			httpget.setHeader(this.referer, url);
		HttpResponse response = httpClient.execute(httpget);
		String content = "";
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			content = EntityUtils.toString(entity, "UTF-8");
		}
	}

}