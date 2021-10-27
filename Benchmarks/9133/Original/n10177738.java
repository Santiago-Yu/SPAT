class n10177738{
    public HttpURLConnection getURLConnection() throws IOException {
        String url_str = getServerURL();
        URL url = new URL(url_str);
        HttpURLConnection urlConnection;
        if (url_str.toLowerCase().startsWith("https")) {
            HttpsURLConnection urlSConnection = (HttpsURLConnection) url.openConnection();
            urlSConnection.setHostnameVerifier(new HostnameVerifier() {

                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            urlConnection = urlSConnection;
        } else urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        if (useHTTPProxy && getProxyLogin() != null) {
            String authString = getProxyLogin() + ":" + getProxyPassword();
            String auth = "Basic " + new sun.misc.BASE64Encoder().encode(authString.getBytes());
            urlConnection.setRequestProperty("Proxy-Authorization", auth);
        }
        urlConnection.setDoOutput(true);
        if (useHTTPProxy) {
            System.getProperties().put("proxySet", "true");
            System.getProperties().put("proxyHost", proxyHost);
            System.getProperties().put("proxyPort", String.valueOf(proxyPort));
        }
        return urlConnection;
    }

}