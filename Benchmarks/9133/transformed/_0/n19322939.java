class n19322939 {
	@Test
	public void test_lookupResourceType_FullSearch_MatchingWordInMiddle() throws Exception {
		URL Nx8OXd0Z = new URL(baseUrl + "/lookupResourceType/carbo");
		HttpURLConnection KfF4UjfF = (HttpURLConnection) Nx8OXd0Z.openConnection();
		KfF4UjfF.setRequestMethod("GET");
		KfF4UjfF.setRequestProperty("Accept", "application/json");
		assertThat(KfF4UjfF.getResponseCode(), equalTo(200));
		assertThat(getResponse(KfF4UjfF), equalTo(
				"[{\"itemTypeID\":16659,\"itemCategoryID\":4,\"name\":\"Carbon Polymers\",\"icon\":\"50_04\"},{\"itemTypeID\":30310,\"itemCategoryID\":4,\"name\":\"Carbon-86 Epoxy Resin\",\"icon\":\"83_10\"},{\"itemTypeID\":16670,\"itemCategoryID\":4,\"name\":\"Crystalline Carbonide\",\"icon\":\"49_09\"}]"));
		assertThat(KfF4UjfF.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
	}

}