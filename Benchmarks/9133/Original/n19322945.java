class n19322945{
    @Test
    public void test_lookupType_FullSearch_CaseSensivity() throws Exception {
        URL url = new URL(baseUrl + "/lookupType/moRO");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        assertThat(connection.getResponseCode(), equalTo(200));
        assertThat(getResponse(connection), equalTo("[{\"itemTypeID\":19724,\"itemCategoryID\":6,\"name\":\"Moros\"},{\"itemTypeID\":19725,\"itemCategoryID\":9,\"name\":\"Moros Blueprint\"}]"));
        assertThat(connection.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
    }

}