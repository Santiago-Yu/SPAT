class n19322947{
    @Test
    public void test_lookupType_FullSearch_TwoWords() throws Exception {
        URL url = new URL(baseUrl + "/lookupType/deep+core");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        assertThat(connection.getResponseCode(), equalTo(200));
        assertThat(getResponse(connection), equalTo("[{\"itemTypeID\":11395,\"itemCategoryID\":16,\"name\":\"Deep Core Mining\",\"icon\":\"50_11\"},{\"itemTypeID\":12108,\"itemCategoryID\":7,\"name\":\"Deep Core Mining Laser I\",\"icon\":\"35_01\",\"metaLevel\":0},{\"itemTypeID\":12109,\"itemCategoryID\":9,\"name\":\"Deep Core Mining Laser I Blueprint\",\"icon\":\"12_08\"},{\"itemTypeID\":18068,\"itemCategoryID\":7,\"name\":\"Modulated Deep Core Miner II\",\"icon\":\"35_01\",\"metaLevel\":5},{\"itemTypeID\":18069,\"itemCategoryID\":9,\"name\":\"Modulated Deep Core Miner II Blueprint\",\"icon\":\"12_08\"},{\"itemTypeID\":24305,\"itemCategoryID\":7,\"name\":\"Modulated Deep Core Strip Miner II\",\"icon\":\"49_05\",\"metaLevel\":5},{\"itemTypeID\":24306,\"itemCategoryID\":9,\"name\":\"Modulated Deep Core Strip Miner II Blueprint\",\"icon\":\"12_08\"},{\"itemTypeID\":28748,\"itemCategoryID\":7,\"name\":\"ORE Deep Core Mining Laser\",\"icon\":\"35_01\",\"metaLevel\":6}]"));
        assertThat(connection.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
    }

}