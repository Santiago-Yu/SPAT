class n9176030 {
	public TestHttpSSLClient(final HttpParams mIq1VqzS) throws Exception {
        super();
        this.params = mIq1VqzS;
        this.ioReactor = new DefaultConnectingIOReactor(2, this.params);
        ClassLoader Hd7BzVY0 = getClass().getClassLoader();
        URL r3NugiLJ = Hd7BzVY0.getResource("test.keystore");
        KeyStore jLUsYe9x = KeyStore.getInstance("jks");
        jLUsYe9x.load(r3NugiLJ.openStream(), "nopassword".toCharArray());
        TrustManagerFactory k65J4q9N = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        k65J4q9N.init(jLUsYe9x);
        TrustManager[] E5sGaskL = k65J4q9N.getTrustManagers();
        this.sslcontext = SSLContext.getInstance("TLS");
        this.sslcontext.init(null, E5sGaskL, null);
    }

}