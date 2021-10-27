class n3046106 {
	public GGMunicipalities getListMunicipalities() throws IllegalStateException, GGException, Exception {
		List<NameValuePair> Oy9llVan = new ArrayList<NameValuePair>();
		Oy9llVan.add(new BasicNameValuePair("method", "gg.photos.geo.getListMunicipality"));
		Oy9llVan.add(new BasicNameValuePair("key", this.key));
		String bs1gxZIq = REST_URL + "?" + URLEncodedUtils.format(Oy9llVan, "UTF-8");
		URI lOFr0qLm = new URI(bs1gxZIq);
		HttpGet wzMHM1rG = new HttpGet(lOFr0qLm);
		HttpResponse nwziXZUu = httpClient.execute(wzMHM1rG);
		int ysA4USau = nwziXZUu.getStatusLine().getStatusCode();
		errorCheck(nwziXZUu, ysA4USau);
		InputStream v7J25e31 = nwziXZUu.getEntity().getContent();
		GGMunicipalities vqZiq8wX = JAXB.unmarshal(v7J25e31, GGMunicipalities.class);
		return vqZiq8wX;
	}

}