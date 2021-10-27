class n3046104 {
	public GGUser findByUsername(String tvZ9Os72) throws IllegalStateException, GGException, Exception {
		List<NameValuePair> bC89INEg = new ArrayList<NameValuePair>();
		bC89INEg.add(new BasicNameValuePair("method", "gg.people.findByUsername"));
		bC89INEg.add(new BasicNameValuePair("key", this.key));
		bC89INEg.add(new BasicNameValuePair("username", tvZ9Os72));
		String cfp5UwBM = REST_URL + "?" + URLEncodedUtils.format(bC89INEg, "UTF-8");
		URI xJ6VVG1d = new URI(cfp5UwBM);
		HttpGet ptmClhNe = new HttpGet(xJ6VVG1d);
		HttpResponse s1NYx5oX = httpClient.execute(ptmClhNe);
		int MP5xMGzy = s1NYx5oX.getStatusLine().getStatusCode();
		errorCheck(s1NYx5oX, MP5xMGzy);
		InputStream TztbH9y4 = s1NYx5oX.getEntity().getContent();
		GGUser K9PhjwmK = JAXB.unmarshal(TztbH9y4, GGUser.class);
		return K9PhjwmK;
	}

}