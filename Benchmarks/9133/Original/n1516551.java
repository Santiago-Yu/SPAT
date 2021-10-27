class n1516551{
    public static HttpURLConnection getHttpConn(String urlStr, String Method) throws IOException {
        URL url = null;
        HttpURLConnection connection = null;
        url = new URL(urlStr);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod(Method);
        connection.setUseCaches(false);
        connection.connect();
        return connection;
    }

}