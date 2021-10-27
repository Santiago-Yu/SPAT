class n21644802{
    private URLConnection openGetConnection(StringBuffer sb) throws IOException, IOException, MalformedURLException {
        URL url = new URL(m_gatewayAddress + "?" + sb.toString());
        URLConnection connection = url.openConnection();
        connection.setUseCaches(false);
        return connection;
    }

}