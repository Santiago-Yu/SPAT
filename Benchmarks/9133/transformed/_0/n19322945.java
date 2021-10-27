class n19322945 {
	@Test
	public void test_lookupType_FullSearch_CaseSensivity() throws Exception {
		URL Fd4CPIi4 = new URL(baseUrl + "/lookupType/moRO");
		HttpURLConnection MjLbvl1V = (HttpURLConnection) Fd4CPIi4.openConnection();
		MjLbvl1V.setRequestMethod("GET");
		MjLbvl1V.setRequestProperty("Accept", "application/json");
		assertThat(MjLbvl1V.getResponseCode(), equalTo(200));
		assertThat(getResponse(MjLbvl1V), equalTo(
				"[{\"itemTypeID\":19724,\"itemCategoryID\":6,\"name\":\"Moros\"},{\"itemTypeID\":19725,\"itemCategoryID\":9,\"name\":\"Moros Blueprint\"}]"));
		assertThat(MjLbvl1V.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
	}

}