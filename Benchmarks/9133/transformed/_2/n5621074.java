class n5621074 {
	public static void upper() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HostnameVerifier hv = new HostnameVerifier() {

			public boolean verify(String urlHostName, SSLSession session) {
				System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
		URL url = new URL("https://test.ctpe.net/payment/query");
		URLConnection conn = url.openConnection();
		String data = "<Request version='1.0'> " + "<Header>  "
				+ "  <Security sender='ff80808109c5bcc00109c5bce9f1003a'/>  " + "</Header>  "
				+ "<Query entity='ff80808109c5bcc00109c5bce9f50056' level='CHANNEL' mode='INTEGRATOR_TEST'> "
				+ "  <User login='ff80808109c5bcc00109c5bce9f20042' pwd='geheim'/>  "
				+ "  <Period from='2006-03-04' to='2006-03-04'/>  " + "  <Types>  " + "    <Type code='RF'/> "
				+ "    <Type code='PA'/>  " + "    <Type code='RV'/>  " + "  </Types>  " + "</Query>  "
				+ "</Request>  ";
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write("load=" + data);
		wr.flush();
		wr.close();
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		for (; (line = rd.readLine()) != null;) {
			System.out.println(line);
		}
		rd.close();
	}

}