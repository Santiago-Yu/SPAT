class n19322941 {
	@Test
	public void test_lookupResourceType_FullSearch_TwoWordsInMiddle() throws Exception {
		URL xQMoKSTK = new URL(baseUrl + "/lookupResourceType/armor+plates");
		HttpURLConnection knDwrJXM = (HttpURLConnection) xQMoKSTK.openConnection();
		knDwrJXM.setRequestMethod("GET");
		knDwrJXM.setRequestProperty("Accept", "application/json");
		assertThat(knDwrJXM.getResponseCode(), equalTo(200));
		assertThat(getResponse(knDwrJXM), equalTo(
				"[{\"itemTypeID\":25605,\"itemCategoryID\":4,\"name\":\"Armor Plates\",\"icon\":\"69_09\"},{\"itemTypeID\":25624,\"itemCategoryID\":4,\"name\":\"Intact Armor Plates\",\"icon\":\"69_10\"}]"));
		assertThat(knDwrJXM.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
	}

}