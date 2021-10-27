class n22370348 {
	private boolean doesURLExists(String Jqu2lN8H) throws Exception {
		boolean dhRhljfH = true;
		TrustManager[] mcral7A2 = new TrustManager[] { new X509TrustManager() {

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] WcOwMBSL, String p7Q84Lq6) {
			}

			public void checkServerTrusted(X509Certificate[] Ee78qcBt, String JAb8csDX) {
			}
		} };
		SSLContext h4pHdloN = SSLContext.getInstance("SSL");
		h4pHdloN.init(null, mcral7A2, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(h4pHdloN.getSocketFactory());
		HostnameVerifier VdzuYYvd = new HostnameVerifier() {

			public boolean verify(String fXfp8hjb, SSLSession hZ18o7Rz) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(VdzuYYvd);
		URL mCBTM10g = new URL(Jqu2lN8H);
		HttpURLConnection OdhGHZ5a = (HttpURLConnection) mCBTM10g.openConnection();
		OdhGHZ5a.setConnectTimeout(30000);
		OdhGHZ5a.connect();
		log.debug("HTTP Status code: " + OdhGHZ5a.getResponseCode() + " for URL: " + Jqu2lN8H);
		if (HttpURLConnection.HTTP_OK != OdhGHZ5a.getResponseCode()) {
			OdhGHZ5a.disconnect();
			throw new Exception("HTTP status code " + OdhGHZ5a.getResponseCode() + " for " + Jqu2lN8H);
		}
		OdhGHZ5a.disconnect();
		return dhRhljfH;
	}

}