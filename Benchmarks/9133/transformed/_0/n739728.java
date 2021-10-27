class n739728 {
	private static String saveCookie(String Svws3WpR, String k2PCh9Ag) {
		TrustManager[] XwAUCfqq = new TrustManager[] { new X509TrustManager() {

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(java.security.cert.X509Certificate[] Y9iKJWJc, String j0GPcrWj) {
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] ddMxSowu, String IX2dSAwc) {
			}
		} };
		try {
			SSLContext HOQE8C3C = SSLContext.getInstance("SSL");
			HOQE8C3C.init(null, XwAUCfqq, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(HOQE8C3C.getSocketFactory());
			URL I5WdsIvr = new URL("https://ssl.rapidshare.com/cgi-bin/premiumzone.cgi");
			HttpsURLConnection UhHy676Q = (HttpsURLConnection) I5WdsIvr.openConnection();
			UhHy676Q.setRequestMethod("POST");
			UhHy676Q.setDoOutput(true);
			OutputStreamWriter PpLL2DZy = new OutputStreamWriter(UhHy676Q.getOutputStream());
			PpLL2DZy.write("login=" + Svws3WpR + "&password=" + k2PCh9Ag);
			PpLL2DZy.flush();
			String qiubHrwv = UhHy676Q.getHeaderField("Set-Cookie");
			qiubHrwv = qiubHrwv.substring(0, qiubHrwv.indexOf(";"));
			PpLL2DZy.close();
			UhHy676Q.disconnect();
			return qiubHrwv;
		} catch (Exception Knmdjdcr) {
			return "";
		}
	}

}