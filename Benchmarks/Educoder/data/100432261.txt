    @Test
    public void test_lookupResourceType_FullSearch_TwoWordsInMiddle() throws Exception {
        URL url = new URL(baseUrl + "/lookupResourceType/armor+plates");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        assertThat(connection.getResponseCode(), equalTo(200));
        assertThat(getResponse(connection), equalTo("[{\"itemTypeID\":25605,\"itemCategoryID\":4,\"name\":\"Armor Plates\",\"icon\":\"69_09\"},{\"itemTypeID\":25624,\"itemCategoryID\":4,\"name\":\"Intact Armor Plates\",\"icon\":\"69_10\"}]"));
        assertThat(connection.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
    }
