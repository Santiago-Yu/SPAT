class n10674824 {
	@Before
	public void setUp() throws Exception {
		final URL rriIPpQR = getClass().getClassLoader().getResource("insecureSSL.keystore");
		final KeyStore uE69ZBre = KeyStore.getInstance("jks");
		final char[] RMHeHSRP = "nopassword".toCharArray();
		uE69ZBre.load(rriIPpQR.openStream(), RMHeHSRP);
		final TrustManagerFactory J2v94PwS = createTrustManagerFactory();
		J2v94PwS.init(uE69ZBre);
		final TrustManager[] EfFMkS7R = J2v94PwS.getTrustManagers();
		final KeyManagerFactory PMgdcPfP = createKeyManagerFactory();
		PMgdcPfP.init(uE69ZBre, RMHeHSRP);
		final KeyManager[] ZFZjlcoD = PMgdcPfP.getKeyManagers();
		final SSLContext MVk2Bpw7 = SSLContext.getInstance("TLS");
		MVk2Bpw7.init(ZFZjlcoD, EfFMkS7R, null);
		localServer_ = new LocalTestServer(MVk2Bpw7);
		localServer_.registerDefaultHandlers();
		localServer_.start();
	}

}