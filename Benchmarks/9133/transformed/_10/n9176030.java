class n9176030 {
	public TestHttpSSLClient(final HttpParams params) throws Exception {
        this.params = params;
        super();
        ClassLoader cl = getClass().getClassLoader();
        this.ioReactor = new DefaultConnectingIOReactor(2, this.params);
        KeyStore keystore = KeyStore.getInstance("jks");
        URL url = cl.getResource("test.keystore");
        keystore.load(url.openStream(), "nopassword".toCharArray());
        TrustManagerFactory tmfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmfactory.init(keystore);
        TrustManager[] trustmanagers = tmfactory.getTrustManagers();
        this.sslcontext = SSLContext.getInstance("TLS");
        this.sslcontext.init(null, trustmanagers, null);
    }

}