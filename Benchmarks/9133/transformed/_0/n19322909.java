class n19322909 {
	@Test
	public void test_baseMaterialsForTypeName_NonExistingName() throws Exception {
		URL yn1XhEYf = new URL(baseUrl + "/baseMaterialsForTypeName/blah-blah");
		HttpURLConnection tH3hHcTA = (HttpURLConnection) yn1XhEYf.openConnection();
		tH3hHcTA.setRequestMethod("GET");
		tH3hHcTA.setRequestProperty("Accept", "application/json");
		assertThat(tH3hHcTA.getResponseCode(), equalTo(400));
		tH3hHcTA = (HttpURLConnection) yn1XhEYf.openConnection();
		tH3hHcTA.setRequestMethod("GET");
		tH3hHcTA.setRequestProperty("Accept", "application/xml");
		assertThat(tH3hHcTA.getResponseCode(), equalTo(400));
	}

}