class n3046108 {
	public GGPhotoInfo getPhotoInfo(String l7xUyUxr, String q3Dy4Oa7)
			throws IllegalStateException, GGException, Exception {
		List<NameValuePair> Lvnb9oM3 = new ArrayList<NameValuePair>();
		Lvnb9oM3.add(new BasicNameValuePair("method", "gg.photos.getInfo"));
		Lvnb9oM3.add(new BasicNameValuePair("key", this.key));
		Lvnb9oM3.add(new BasicNameValuePair("photo_id", l7xUyUxr));
		if (null != q3Dy4Oa7) {
			Lvnb9oM3.add(new BasicNameValuePair("language", q3Dy4Oa7));
		}
		String O9Mpi8n1 = REST_URL + "?" + URLEncodedUtils.format(Lvnb9oM3, "UTF-8");
		URI a797Bklh = new URI(O9Mpi8n1);
		HttpGet ToL4Vwlv = new HttpGet(a797Bklh);
		HttpResponse ZFlyhBz1 = httpClient.execute(ToL4Vwlv);
		int NNpQkCjr = ZFlyhBz1.getStatusLine().getStatusCode();
		errorCheck(ZFlyhBz1, NNpQkCjr);
		InputStream O4GQDt6a = ZFlyhBz1.getEntity().getContent();
		GGPhotoInfo w4aC5got = JAXB.unmarshal(O4GQDt6a, GGPhotoInfo.class);
		return w4aC5got;
	}

}