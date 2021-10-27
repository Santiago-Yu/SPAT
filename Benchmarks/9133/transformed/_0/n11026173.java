class n11026173 {
	public static URLConnection getURLConnection(URL puD0nELZ, boolean W0uyYb2Q)
			throws KeyManagementException, NoSuchAlgorithmException, UnknownHostException, IOException {
		SSLSocketFactory s3QhFFxY = null;
		if (W0uyYb2Q) {
			SSLContext M0dYRgMs = SSLContext.getInstance("SSL");
			M0dYRgMs.init(null, getAllTrustingTrustManager(), new java.security.SecureRandom());
			s3QhFFxY = M0dYRgMs.getSocketFactory();
		} else {
			s3QhFFxY = (SSLSocketFactory) SSLSocketFactory.getDefault();
		}
		HttpsURLConnection.setDefaultSSLSocketFactory(s3QhFFxY);
		return puD0nELZ.openConnection();
	}

}