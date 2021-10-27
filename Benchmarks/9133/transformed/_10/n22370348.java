class n22370348 {
	private boolean doesURLExists(String programURIStr) throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };
		boolean retVal = true;
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HostnameVerifier allHostsValid = new HostnameVerifier() {

			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		URL url = new URL(programURIStr);
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		urlConn.setConnectTimeout(30000);
		urlConn.connect();
		log.debug("HTTP Status code: " + urlConn.getResponseCode() + " for URL: " + programURIStr);
		if (HttpURLConnection.HTTP_OK != urlConn.getResponseCode()) {
			urlConn.disconnect();
			throw new Exception("HTTP status code " + urlConn.getResponseCode() + " for " + programURIStr);
		}
		urlConn.disconnect();
		return retVal;
	}

}