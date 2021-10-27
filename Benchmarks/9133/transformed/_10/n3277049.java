class n3277049 {
	public java.security.cert.X509Certificate[] getServerCerts() throws IOException {
		String callURL = theURL;
		java.net.HttpURLConnection conn;
		callURL += "?method=test";
		java.net.URL url = new java.net.URL(callURL);
		conn = (java.net.HttpURLConnection) url.openConnection();
		if (isFollowingRedirects != null)
			conn.setInstanceFollowRedirects(isFollowingRedirects.booleanValue());
		if (theConnectTimeout >= 0)
			conn.setConnectTimeout(theConnectTimeout);
		if (theReadTimeout >= 0)
			conn.setReadTimeout(theReadTimeout);
		if (conn instanceof javax.net.ssl.HttpsURLConnection) {
			javax.net.ssl.SSLContext sc;
			SecurityRetriever retriever = new SecurityRetriever();
			try {
				sc = javax.net.ssl.SSLContext.getInstance("SSL");
				sc.init(theKeyManagers, new javax.net.ssl.TrustManager[] { retriever },
						new java.security.SecureRandom());
			} catch (java.security.GeneralSecurityException e) {
				log.error("Could not initialize SSL context", e);
				IOException toThrow = new IOException("Could not initialize SSL context: " + e.getMessage());
				toThrow.setStackTrace(e.getStackTrace());
				throw toThrow;
			}
			javax.net.ssl.HttpsURLConnection sConn = (javax.net.ssl.HttpsURLConnection) conn;
			sConn.setSSLSocketFactory(sc.getSocketFactory());
			sConn.setHostnameVerifier(new javax.net.ssl.HostnameVerifier() {

				public boolean verify(String hostname, javax.net.ssl.SSLSession session) {
					return true;
				}
			});
			try {
				conn.connect();
			} catch (IOException e) {
				if (retriever.getCerts() == null)
					throw e;
			}
			return retriever.getCerts();
		} else
			return null;
	}

}