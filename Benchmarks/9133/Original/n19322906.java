class n19322906{
    @Test
    public void test_baseMaterialsForTypeID_NonExistingID() throws Exception {
        URL url = new URL(baseUrl + "/baseMaterialsForTypeID/1234567890");
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