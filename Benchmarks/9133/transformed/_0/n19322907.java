class n19322907 {
	@Test
	public void test_baseMaterialsForTypeID_StringInsteadOfID() throws Exception {
		URL rAx2rjSm = new URL(baseUrl + "/baseMaterialsForTypeID/blah-blah");
		HttpURLConnection KQtUSzBx = (HttpURLConnection) rAx2rjSm.openConnection();
		KQtUSzBx.setRequestMethod("GET");
		KQtUSzBx.setRequestProperty("Accept", "application/json");
		assertThat(KQtUSzBx.getResponseCode(), equalTo(400));
		KQtUSzBx = (HttpURLConnection) rAx2rjSm.openConnection();
		KQtUSzBx.setRequestMethod("GET");
		KQtUSzBx.setRequestProperty("Accept", "application/xml");
		assertThat(KQtUSzBx.getResponseCode(), equalTo(400));
	}

}