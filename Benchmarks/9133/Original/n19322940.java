class n19322940{
    @Test
    public void test_lookupResourceType_FullSearch_TwoWords() throws Exception {
        URL url = new URL(baseUrl + "/lookupResourceType/alloyed+tritanium");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        assertThat(connection.getResponseCode(), equalTo(200));
        assertThat(getResponse(connection), equalTo("[{\"itemTypeID\":25595,\"itemCategoryID\":4,\"name\":\"Alloyed Tritanium Bar\",\"icon\":\"69_11\"}]"));
        assertThat(connection.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
    }

}