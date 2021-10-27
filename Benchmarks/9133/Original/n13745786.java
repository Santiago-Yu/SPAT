class n13745786{
    private String fetchHtml(URL url) throws IOException {
        URLConnection connection;
        if (StringUtils.isNotBlank(proxyHost) && proxyPort != null) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(proxyHost, proxyPort));
            connection = url.openConnection(proxy);
        } else {
            connection = url.openConnection();
        }
        Object content = connection.getContent();
        if (content instanceof InputStream) {
            return IOUtils.toString(InputStream.class.cast(content));
        } else {
            String msg = "Bad content type! " + content.getClass();
            log.error(msg);
            throw new IOException(msg);
        }
    }

}