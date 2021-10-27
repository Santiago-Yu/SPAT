class n19322911 {
	@Test
	public void test_blueprintTypeByTypeID_NonExistingID() throws Exception {
		URL FafQnq5s = new URL(baseUrl + "/blueprintTypeByTypeID/1234567890");
		HttpURLConnection gI9aFIsJ = (HttpURLConnection) FafQnq5s.openConnection();
		gI9aFIsJ.setRequestMethod("GET");
		gI9aFIsJ.setRequestProperty("Accept", "application/json");
		assertThat(gI9aFIsJ.getResponseCode(), equalTo(400));
		gI9aFIsJ = (HttpURLConnection) FafQnq5s.openConnection();
		gI9aFIsJ.setRequestMethod("GET");
		gI9aFIsJ.setRequestProperty("Accept", "application/xml");
		assertThat(gI9aFIsJ.getResponseCode(), equalTo(400));
	}

}