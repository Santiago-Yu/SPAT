class n14537899 {
	private HttpsURLConnection setUpConnection(URL yjZoori5)
			throws NoSuchAlgorithmException, KeyManagementException, IOException {
		HttpsURLConnection tGhNv2wl = (HttpsURLConnection) yjZoori5.openConnection();
		tGhNv2wl.setAllowUserInteraction(true);
		tGhNv2wl.setUseCaches(false);
		tGhNv2wl.setDoInput(true);
		tGhNv2wl.setDoOutput(true);
		SSLContext bTjSOX6u = SSLContext.getInstance(SSL_PROTOCOL);
		bTjSOX6u.init(new KeyManager[] { new MyKeyManager() }, new TrustManager[] { new BypassTrustManager() }, null);
		tGhNv2wl.setSSLSocketFactory(bTjSOX6u.getSocketFactory());
		return tGhNv2wl;
	}

}