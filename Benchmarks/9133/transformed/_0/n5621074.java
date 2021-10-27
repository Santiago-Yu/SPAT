class n5621074 {
	public static void upper() throws Exception {
		TrustManager[] ur5Nc4mE = new TrustManager[] { new X509TrustManager() {

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(java.security.cert.X509Certificate[] LJIU30Rq, String llFDBtEk) {
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] dJgAHwNh, String WWZ7EWGx) {
			}
		} };
		SSLContext kBhUytXz = SSLContext.getInstance("SSL");
		kBhUytXz.init(null, ur5Nc4mE, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(kBhUytXz.getSocketFactory());
		HostnameVerifier op0qa5s7 = new HostnameVerifier() {

			public boolean verify(String Y3Txrtd2, SSLSession Fgw2fRN6) {
				System.out.println("Warning: URL Host: " + Y3Txrtd2 + " vs. " + Fgw2fRN6.getPeerHost());
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(op0qa5s7);
		URL FN1255se = new URL("https://test.ctpe.net/payment/query");
		URLConnection dWw4AmPY = FN1255se.openConnection();
		String qe4OKhVV = "<Request version='1.0'> " + "<Header>  "
				+ "  <Security sender='ff80808109c5bcc00109c5bce9f1003a'/>  " + "</Header>  "
				+ "<Query entity='ff80808109c5bcc00109c5bce9f50056' level='CHANNEL' mode='INTEGRATOR_TEST'> "
				+ "  <User login='ff80808109c5bcc00109c5bce9f20042' pwd='geheim'/>  "
				+ "  <Period from='2006-03-04' to='2006-03-04'/>  " + "  <Types>  " + "    <Type code='RF'/> "
				+ "    <Type code='PA'/>  " + "    <Type code='RV'/>  " + "  </Types>  " + "</Query>  "
				+ "</Request>  ";
		dWw4AmPY.setDoOutput(true);
		OutputStreamWriter BjMNZ88w = new OutputStreamWriter(dWw4AmPY.getOutputStream());
		BjMNZ88w.write("load=" + qe4OKhVV);
		BjMNZ88w.flush();
		BjMNZ88w.close();
		BufferedReader fGHs11Zp = new BufferedReader(new InputStreamReader(dWw4AmPY.getInputStream()));
		String pPmTdwFO;
		while ((pPmTdwFO = fGHs11Zp.readLine()) != null) {
			System.out.println(pPmTdwFO);
		}
		fGHs11Zp.close();
	}

}