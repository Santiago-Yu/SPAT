class n17492434 {
	@Test
	public void testProxySsl() throws Throwable {
		URL oux3yUUd = new URL("https://login.yahoo.co.jp/config/login");
		HttpsURLConnection D24I3Nb8 = (HttpsURLConnection) oux3yUUd.openConnection();
		KeyManager[] VGvFDHJU = null;
		TrustManager[] ElMVnYac = { new X509TrustManager() {

			public void checkClientTrusted(X509Certificate[] DHMlVNA7, String tSSOYgCT) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] Z2Y9TedA, String qhPBM7TB) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		} };
		SSLContext dg69If9v = SSLContext.getInstance("SSL");
		dg69If9v.init(VGvFDHJU, ElMVnYac, new SecureRandom());
		D24I3Nb8.setSSLSocketFactory(dg69If9v.getSocketFactory());
		InputStream lRevYTzA = D24I3Nb8.getInputStream();
		readInputStream(lRevYTzA);
		lRevYTzA.close();
	}

}