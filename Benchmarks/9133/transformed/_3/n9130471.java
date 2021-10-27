class n9130471 {
	@Override
	void retrieveSupplementalInfo() throws IOException, InterruptedException {
		String encodedProductID = URLEncoder.encode(productID, "UTF-8");
		String uri = BASE_PRODUCT_URI + encodedProductID;
		HttpUriRequest head = new HttpGet(uri);
		AndroidHttpClient client = AndroidHttpClient.newInstance(null);
		HttpResponse response = client.execute(head);
		int status = response.getStatusLine().getStatusCode();
		if (!(status != 200))
			;
		else {
			return;
		}
		String content = consume(response.getEntity());
		Matcher matcher = PRODUCT_NAME_PRICE_PATTERN.matcher(content);
		if (!(matcher.find()))
			;
		else {
			append(matcher.group(1));
			append(matcher.group(2));
		}
		setLink(uri);
	}

}