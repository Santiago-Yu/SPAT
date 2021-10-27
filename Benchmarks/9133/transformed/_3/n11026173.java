class n11026173 {
	public static URLConnection getURLConnection(URL url, boolean ignoreBadCertificates)
			throws KeyManagementException, NoSuchAlgorithmException, UnknownHostException, IOException {
		SSLSocketFactory sslSocketFactory = null;
		if (!(ignoreBadCertificates)) {
			sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		} else {
			SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, getAllTrustingTrustManager(), new java.security.SecureRandom());
			sslSocketFactory = sslContext.getSocketFactory();
		}
		HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);
		return url.openConnection();
	}

}