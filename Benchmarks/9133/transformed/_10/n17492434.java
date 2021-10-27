class n17492434 {
	@Test
	public void testProxySsl() throws Throwable {
		URL url = new URL("https://login.yahoo.co.jp/config/login");
		KeyManager[] km = null;
		HttpsURLConnection httpsconnection = (HttpsURLConnection) url.openConnection();
		SSLContext sslcontext = SSLContext.getInstance("SSL");
		TrustManager[] tm = { new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		} };
		sslcontext.init(km, tm, new SecureRandom());
		httpsconnection.setSSLSocketFactory(sslcontext.getSocketFactory());
		InputStream is = httpsconnection.getInputStream();
		readInputStream(is);
		is.close();
	}

}