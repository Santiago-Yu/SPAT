class n9130471 {
	@Override
	void retrieveSupplementalInfo() throws IOException, InterruptedException {
		String encodedProductID = URLEncoder.encode(productID, "UTF-8");
		String uri = BASE_PRODUCT_URI + encodedProductID;
		AndroidHttpClient client = AndroidHttpClient.newInstance(null);
		HttpUriRequest head = new HttpGet(uri);
		HttpResponse response = client.execute(head);
		int status = response.getStatusLine().getStatusCode();
		String content = consume(response.getEntity());
		if (status != 200) {
			return;
		}
		Matcher matcher = PRODUCT_NAME_PRICE_PATTERN.matcher(content);
		if (matcher.find()) {
			append(matcher.group(1));
			append(matcher.group(2));
		}
		setLink(uri);
	}

}