class n16378761{
    public static void main(String[] args) throws Exception {
        HttpGet get = new HttpGet("https://localhost/docs/index.html");
        DefaultHttpClient client = new DefaultHttpClient();
        ServerConfig config = new ServerConfig(new Properties());
        config.setParam("https.keyStoreFile", "test.keystore");
        config.setParam("https.keyPassword", "nopassword");
        config.setParam("https.keyStoreType", "JKS");
        config.setParam("https.protocol", "SSLv3");
        SSLContextCreator ssl = new SSLContextCreator(config);
        SSLContext ctx = ssl.getSSLContext();
        SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);
        Scheme sch = new Scheme("https", 443, socketFactory);
        client.getConnectionManager().getSchemeRegistry().register(sch);
        HttpResponse response = client.execute(get);
        System.out.println(response.getStatusLine().getStatusCode());
    }

}