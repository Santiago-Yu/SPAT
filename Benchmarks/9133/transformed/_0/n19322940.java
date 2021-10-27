class n19322940 {
	@Test
	public void test_lookupResourceType_FullSearch_TwoWords() throws Exception {
		URL D1RasGlN = new URL(baseUrl + "/lookupResourceType/alloyed+tritanium");
		HttpURLConnection XVpfHtg6 = (HttpURLConnection) D1RasGlN.openConnection();
		XVpfHtg6.setRequestMethod("GET");
		XVpfHtg6.setRequestProperty("Accept", "application/json");
		assertThat(XVpfHtg6.getResponseCode(), equalTo(200));
		assertThat(getResponse(XVpfHtg6), equalTo(
				"[{\"itemTypeID\":25595,\"itemCategoryID\":4,\"name\":\"Alloyed Tritanium Bar\",\"icon\":\"69_11\"}]"));
		assertThat(XVpfHtg6.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
	}

}