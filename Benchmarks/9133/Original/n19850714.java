class n19850714{
    public HttpClient(String urlString, String jsonMessage) throws Exception {
        this.jsonMessage = jsonMessage;
        connection = (HttpURLConnection) (new URL(urlString)).openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "text/plain");
    }

}