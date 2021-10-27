    public static URLConnection openProxiedConnection(URL url) throws IOException {
        if (proxyHost != null) {
            System.getProperties().put("proxySet", "true");
            System.getProperties().put("proxyHost", proxyHost);
            System.getProperties().put("proxyPort", proxyPort);
        }
        URLConnection cnx = url.openConnection();
        if (proxyUsername != null) {
            cnx.setRequestProperty("Proxy-Authorization", proxyEncodedPassword);
        }
        return cnx;
    }
