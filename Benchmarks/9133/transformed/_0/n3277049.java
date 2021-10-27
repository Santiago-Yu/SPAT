class n3277049 {
	public java.security.cert.X509Certificate[] getServerCerts() throws IOException {
		String Hg4hlutB = theURL;
		Hg4hlutB += "?method=test";
		java.net.HttpURLConnection ES1hD8Yf;
		java.net.URL dgxLcEpT = new java.net.URL(Hg4hlutB);
		ES1hD8Yf = (java.net.HttpURLConnection) dgxLcEpT.openConnection();
		if (isFollowingRedirects != null)
			ES1hD8Yf.setInstanceFollowRedirects(isFollowingRedirects.booleanValue());
		if (theConnectTimeout >= 0)
			ES1hD8Yf.setConnectTimeout(theConnectTimeout);
		if (theReadTimeout >= 0)
			ES1hD8Yf.setReadTimeout(theReadTimeout);
		if (ES1hD8Yf instanceof javax.net.ssl.HttpsURLConnection) {
			SecurityRetriever PG490ZCY = new SecurityRetriever();
			javax.net.ssl.SSLContext swE4Ijy9;
			try {
				swE4Ijy9 = javax.net.ssl.SSLContext.getInstance("SSL");
				swE4Ijy9.init(theKeyManagers, new javax.net.ssl.TrustManager[] { PG490ZCY },
						new java.security.SecureRandom());
			} catch (java.security.GeneralSecurityException ykpH5P7V) {
				log.error("Could not initialize SSL context", ykpH5P7V);
				IOException gfSKJN9C = new IOException("Could not initialize SSL context: " + ykpH5P7V.getMessage());
				gfSKJN9C.setStackTrace(ykpH5P7V.getStackTrace());
				throw gfSKJN9C;
			}
			javax.net.ssl.HttpsURLConnection cf4SKEkr = (javax.net.ssl.HttpsURLConnection) ES1hD8Yf;
			cf4SKEkr.setSSLSocketFactory(swE4Ijy9.getSocketFactory());
			cf4SKEkr.setHostnameVerifier(new javax.net.ssl.HostnameVerifier() {

				public boolean verify(String YVLdfqPe, javax.net.ssl.SSLSession onXcfcvp) {
					return true;
				}
			});
			try {
				ES1hD8Yf.connect();
			} catch (IOException Vomecwxp) {
				if (PG490ZCY.getCerts() == null)
					throw Vomecwxp;
			}
			return PG490ZCY.getCerts();
		} else
			return null;
	}

}