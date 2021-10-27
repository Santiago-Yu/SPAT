class n19322943{
    @Test
    public void test_lookupType_NonExistingName() throws Exception {
        URL url = new URL(baseUrl + "/lookupType/blah-blah");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        assertThat(connection.getResponseCode(), equalTo(200));
        assertThat(getResponse(connection), equalTo("[]"));
        assertThat(connection.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        assertThat(connection.getResponseCode(), equalTo(200));
        assertThat(getResponse(connection), equalTo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><rowset/>"));
        assertThat(connection.getHeaderField("Content-Type"), equalTo("application/xml; charset=utf-8"));
    }

}