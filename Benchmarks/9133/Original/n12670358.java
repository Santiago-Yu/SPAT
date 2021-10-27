class n12670358{
    private InputStream loadFromUrl(URL url, String contentType) throws IOException {
        Proxy proxy = null;
        if (isUseProxy) {
            Authenticator.setDefault(new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
                }
            });
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        } else {
            proxy = Proxy.NO_PROXY;
        }
        URLConnection connection = url.openConnection(proxy);
        connection.setRequestProperty("Accept-Charset", DEFAULT_CHARSET);
        connection.setRequestProperty("Content-Type", contentType);
        connection.setRequestProperty("User-Agent", USER_AGENT);
        InputStream response = connection.getInputStream();
        return response;
    }

}