    public static Object loadXmlFromUrl(URL url, int timeout, XML_TYPE xmlType) throws IOException {
        URLConnection connection = url.openConnection();
        connection.setConnectTimeout(timeout);
        connection.setReadTimeout(timeout);
        BufferedInputStream buffInputStream = new BufferedInputStream(connection.getInputStream());
        return loadXml(buffInputStream, xmlType);
    }
