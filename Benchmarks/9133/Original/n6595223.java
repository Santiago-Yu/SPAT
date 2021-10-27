class n6595223{
    private void testConnection(String address) throws Exception {
        URL url = new URL(address);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setUseCaches(false);
        try {
            con.connect();
            assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode());
        } finally {
            con.disconnect();
        }
    }

}