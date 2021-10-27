class n19125824{
    public HttpURLConnection openConnection() throws IOException {
        URL url = new URL("http", host, request);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Host", host);
        for (Map.Entry<String, List<String>> entry : mapOfHeaders.entrySet()) {
            for (String value : entry.getValue()) {
                connection.addRequestProperty(entry.getKey(), value);
            }
        }
        return connection;
    }

}