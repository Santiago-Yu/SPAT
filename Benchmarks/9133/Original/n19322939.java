class n19322939{
    @Test
    public void test_lookupResourceType_FullSearch_MatchingWordInMiddle() throws Exception {
        URL url = new URL(baseUrl + "/lookupResourceType/carbo");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        assertThat(connection.getResponseCode(), equalTo(200));
        assertThat(getResponse(connection), equalTo("[{\"itemTypeID\":16659,\"itemCategoryID\":4,\"name\":\"Carbon Polymers\",\"icon\":\"50_04\"},{\"itemTypeID\":30310,\"itemCategoryID\":4,\"name\":\"Carbon-86 Epoxy Resin\",\"icon\":\"83_10\"},{\"itemTypeID\":16670,\"itemCategoryID\":4,\"name\":\"Crystalline Carbonide\",\"icon\":\"49_09\"}]"));
        assertThat(connection.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
    }

}