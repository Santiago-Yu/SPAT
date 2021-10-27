class n9130471 {
	@Override
	void retrieveSupplementalInfo() throws IOException, InterruptedException {
		String hmEKIehd = URLEncoder.encode(productID, "UTF-8");
		String eF1ZN0wP = BASE_PRODUCT_URI + hmEKIehd;
		HttpUriRequest r4bNyqHM = new HttpGet(eF1ZN0wP);
		AndroidHttpClient Xqba8beW = AndroidHttpClient.newInstance(null);
		HttpResponse SBR22ukK = Xqba8beW.execute(r4bNyqHM);
		int OaouZt5s = SBR22ukK.getStatusLine().getStatusCode();
		if (OaouZt5s != 200) {
			return;
		}
		String MDf9M1x5 = consume(SBR22ukK.getEntity());
		Matcher ZcbJqaGo = PRODUCT_NAME_PRICE_PATTERN.matcher(MDf9M1x5);
		if (ZcbJqaGo.find()) {
			append(ZcbJqaGo.group(1));
			append(ZcbJqaGo.group(2));
		}
		setLink(eF1ZN0wP);
	}

}