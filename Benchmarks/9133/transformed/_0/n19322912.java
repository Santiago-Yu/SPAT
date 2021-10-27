class n19322912 {
	@Test
	public void test_blueprintTypeByTypeID_StringInsteadOfID() throws Exception {
		URL c0lAXZbd = new URL(baseUrl + "/blueprintTypeByTypeID/blah-blah");
		HttpURLConnection zeHvKSTr = (HttpURLConnection) c0lAXZbd.openConnection();
		zeHvKSTr.setRequestMethod("GET");
		zeHvKSTr.setRequestProperty("Accept", "application/json");
		assertThat(zeHvKSTr.getResponseCode(), equalTo(400));
		zeHvKSTr = (HttpURLConnection) c0lAXZbd.openConnection();
		zeHvKSTr.setRequestMethod("GET");
		zeHvKSTr.setRequestProperty("Accept", "application/xml");
		assertThat(zeHvKSTr.getResponseCode(), equalTo(400));
	}

}