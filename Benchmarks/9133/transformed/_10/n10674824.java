class n10674824 {
	@Before
	public void setUp() throws Exception {
		final KeyStore keystore = KeyStore.getInstance("jks");
		final URL url = getClass().getClassLoader().getResource("insecureSSL.keystore");
		final char[] pwd = "nopassword".toCharArray();
		keystore.load(url.openStream(), pwd);
		final TrustManagerFactory trustManagerFactory = createTrustManagerFactory();
		trustManagerFactory.init(keystore);
		final TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
		final KeyManagerFactory keyManagerFactory = createKeyManagerFactory();
		keyManagerFactory.init(keystore, pwd);
		final KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
		final SSLContext serverSSLContext = SSLContext.getInstance("TLS");
		serverSSLContext.init(keyManagers, trustManagers, null);
		localServer_ = new LocalTestServer(serverSSLContext);
		localServer_.registerDefaultHandlers();
		localServer_.start();
	}

}