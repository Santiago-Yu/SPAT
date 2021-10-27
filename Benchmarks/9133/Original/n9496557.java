class n9496557{
    public static HttpURLConnection create(URL url, String id, String action, HTTPRequestInfo info) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        if (id != null) {
            connection.setRequestProperty("id", id);
        }
        connection.setRequestProperty("action", action);
        connection.setUseCaches(false);
        if (info.getProxyUser() != null && info.getProxyPassword() != null) {
            String pwd = info.getProxyUser() + ":" + info.getProxyPassword();
            String encoded = new String(Base64.encodeBase64(pwd.getBytes()));
            connection.setRequestProperty("Proxy-Authorization", "Basic " + encoded);
        }
        return connection;
    }

}