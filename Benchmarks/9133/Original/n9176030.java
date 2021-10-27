class n9176030{
    public TestHttpSSLClient(final HttpParams params) throws Exception {
        super();
        this.params = params;
        this.ioReactor = new DefaultConnectingIOReactor(2, this.params);
        ClassLoader cl = getClass().getClassLoader();
        URL url = cl.getResource("test.keystore");
        KeyStore keystore = KeyStore.getInstance("jks");
        keystore.load(url.openStream(), "nopassword".toCharArray());
        TrustManagerFactory tmfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmfactory.init(keystore);
        TrustManager[] trustmanagers = tmfactory.getTrustManagers();
        this.sslcontext = SSLContext.getInstance("TLS");
        this.sslcontext.init(null, trustmanagers, null);
    }

}