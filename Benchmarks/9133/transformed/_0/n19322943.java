class n19322943 {
	@Test
	public void test_lookupType_NonExistingName() throws Exception {
		URL uP2cIHoG = new URL(baseUrl + "/lookupType/blah-blah");
		HttpURLConnection aaUhF1J7 = (HttpURLConnection) uP2cIHoG.openConnection();
		aaUhF1J7.setRequestMethod("GET");
		aaUhF1J7.setRequestProperty("Accept", "application/json");
		assertThat(aaUhF1J7.getResponseCode(), equalTo(200));
		assertThat(getResponse(aaUhF1J7), equalTo("[]"));
		assertThat(aaUhF1J7.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
		aaUhF1J7 = (HttpURLConnection) uP2cIHoG.openConnection();
		aaUhF1J7.setRequestMethod("GET");
		aaUhF1J7.setRequestProperty("Accept", "application/xml");
		assertThat(aaUhF1J7.getResponseCode(), equalTo(200));
		assertThat(getResponse(aaUhF1J7),
				equalTo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><rowset/>"));
		assertThat(aaUhF1J7.getHeaderField("Content-Type"), equalTo("application/xml; charset=utf-8"));
	}

}