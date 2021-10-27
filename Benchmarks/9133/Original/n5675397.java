class n5675397{
    private void delete(String location) throws Exception {
        URL url = new URL(location);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK && responseCode != HttpURLConnection.HTTP_NO_CONTENT) {
            String response = "location " + location + " responded: " + conn.getResponseMessage() + " (" + responseCode + ")";
            fail(response);
        }
    }

}