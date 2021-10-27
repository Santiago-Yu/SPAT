class n9636735{
    public static HttpURLConnection createSoapHttpURLConnection(String url) throws MalformedURLException, IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.addRequestProperty("Connection", "close");
        connection.addRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        return connection;
    }

}