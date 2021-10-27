class n17519757{
    public static InputStream download(String endereco, ProxyConfig proxy) {
        if (proxy != null) {
            System.getProperties().put("proxySet", "true");
            System.getProperties().put("proxyPort", proxy.getPorta());
            System.getProperties().put("proxyHost", proxy.getHost());
            Authenticator.setDefault(new ProxyAuthenticator(proxy.getUsuario(), proxy.getSenha()));
        }
        try {
            URL url = new URL(endereco);
            ;
            URLConnection connection = url.openConnection();
            InputStream bis = new BufferedInputStream(connection.getInputStream());
            return bis;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}