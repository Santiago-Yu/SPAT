class n3636069 {
	public void executeAction(JobContext context) throws Exception {
		HttpClient httpClient = (HttpClient) context.resolve("httpClient");
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
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
		HttpEntity entity = response.getEntity();
		String content = "";
		content = (entity != null) ? EntityUtils.toString(entity, "UTF-8") : content;
	}

}