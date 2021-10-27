class n3046105 {
	public GGLicenses getLicensesInfo() throws IllegalStateException, GGException, Exception {
		List<NameValuePair> Yn0Pr6F0 = new ArrayList<NameValuePair>();
		Yn0Pr6F0.add(new BasicNameValuePair("method", "gg.photos.licenses.getInfo"));
		Yn0Pr6F0.add(new BasicNameValuePair("key", this.key));
		String uha4Y6qi = REST_URL + "?" + URLEncodedUtils.format(Yn0Pr6F0, "UTF-8");
		URI eedFIuir = new URI(uha4Y6qi);
		HttpGet BnwnNtS3 = new HttpGet(eedFIuir);
		HttpResponse GxL0KQQe = httpClient.execute(BnwnNtS3);
		int t0e0kE8g = GxL0KQQe.getStatusLine().getStatusCode();
		errorCheck(GxL0KQQe, t0e0kE8g);
		InputStream cciRe6EG = GxL0KQQe.getEntity().getContent();
		GGLicenses FMlaLU4l = JAXB.unmarshal(cciRe6EG, GGLicenses.class);
		return FMlaLU4l;
	}

}