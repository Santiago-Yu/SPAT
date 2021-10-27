class n3046107 {
	public GGProvinces getListProvinces() throws IllegalStateException, GGException, Exception {
		List<NameValuePair> cyfC7rMP = new ArrayList<NameValuePair>();
		cyfC7rMP.add(new BasicNameValuePair("method", "gg.photos.geo.getListProvinces"));
		cyfC7rMP.add(new BasicNameValuePair("key", this.key));
		String LqdOaajF = REST_URL + "?" + URLEncodedUtils.format(cyfC7rMP, "UTF-8");
		URI TQJsIavk = new URI(LqdOaajF);
		HttpGet DMIQ8G74 = new HttpGet(TQJsIavk);
		HttpResponse yyN2gsTo = httpClient.execute(DMIQ8G74);
		int R9lhAjfz = yyN2gsTo.getStatusLine().getStatusCode();
		errorCheck(yyN2gsTo, R9lhAjfz);
		InputStream pR0MbQAk = yyN2gsTo.getEntity().getContent();
		GGProvinces FhJcI2yC = JAXB.unmarshal(pR0MbQAk, GGProvinces.class);
		return FhJcI2yC;
	}

}