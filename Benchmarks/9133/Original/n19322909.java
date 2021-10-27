class n19322909{
    @Test
    public void test_baseMaterialsForTypeName_NonExistingName() throws Exception {
        URL url = new URL(baseUrl + "/baseMaterialsForTypeName/blah-blah");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        assertThat(connection.getResponseCode(), equalTo(400));
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        assertThat(connection.getResponseCode(), equalTo(400));
    }

}