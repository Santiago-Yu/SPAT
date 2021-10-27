class n19322944 {
	@Test
	public void test_lookupType_TooShortName() throws Exception {
		URL V1qeTFfM = new URL(baseUrl + "/lookupType/A");
		HttpURLConnection TFtiHeae = (HttpURLConnection) V1qeTFfM.openConnection();
		TFtiHeae.setRequestMethod("GET");
		TFtiHeae.setRequestProperty("Accept", "application/json");
		assertThat(TFtiHeae.getResponseCode(), equalTo(400));
		TFtiHeae = (HttpURLConnection) V1qeTFfM.openConnection();
		TFtiHeae.setRequestMethod("GET");
		TFtiHeae.setRequestProperty("Accept", "application/xml");
		assertThat(TFtiHeae.getResponseCode(), equalTo(400));
	}

}