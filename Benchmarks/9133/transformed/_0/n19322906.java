class n19322906 {
	@Test
	public void test_baseMaterialsForTypeID_NonExistingID() throws Exception {
		URL UpfpusaT = new URL(baseUrl + "/baseMaterialsForTypeID/1234567890");
		HttpURLConnection QXB6Znxi = (HttpURLConnection) UpfpusaT.openConnection();
		QXB6Znxi.setRequestMethod("GET");
		QXB6Znxi.setRequestProperty("Accept", "application/json");
		assertThat(QXB6Znxi.getResponseCode(), equalTo(400));
		QXB6Znxi = (HttpURLConnection) UpfpusaT.openConnection();
		QXB6Znxi.setRequestMethod("GET");
		QXB6Znxi.setRequestProperty("Accept", "application/xml");
		assertThat(QXB6Znxi.getResponseCode(), equalTo(400));
	}

}