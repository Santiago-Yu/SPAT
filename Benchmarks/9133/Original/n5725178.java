class n5725178{
    protected HttpURLConnection openConnection(final String url) throws IOException {
        final HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("User-Agent", userAgent);
        connection.setRequestProperty("Accept", "application/xhtml+xml,application/xml,text/xml;q=0.9,*/*;q=0.8");
        connection.setRequestProperty("Accept-Language", "ja,en-us;q=0.7,en;q=0.3");
        connection.setRequestProperty("Accept-Encoding", "deflate");
        connection.setRequestProperty("Accept-Charset", "utf-8");
        connection.setRequestProperty("Authorization", "Basic ".concat(base64Encode((username.concat(":").concat(password)).getBytes("UTF-8"))));
        return connection;
    }

}