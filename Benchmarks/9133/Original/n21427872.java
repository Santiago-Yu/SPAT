class n21427872{
    private HttpURLConnection setUpHttpConnection(URL url, int length) throws IOException, ProtocolException {
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        httpConn.setRequestProperty("Content-Length", String.valueOf(length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", "\"http://www.webserviceX.NET/GetQuote\"");
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        return httpConn;
    }

}