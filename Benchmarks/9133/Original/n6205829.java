class n6205829{
    private int testAccesspoint(String s) throws IOException {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(s);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "text/xml");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode >= 500) {
                return 100;
            } else {
                return 0;
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}