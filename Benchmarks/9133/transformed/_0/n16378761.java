class n16378761 {
	public static void main(String[] ni3ZGSMj) throws Exception {
		HttpGet It4ls5Km = new HttpGet("https://localhost/docs/index.html");
		DefaultHttpClient Nly8j1OO = new DefaultHttpClient();
		ServerConfig URwA6iEQ = new ServerConfig(new Properties());
		URwA6iEQ.setParam("https.keyStoreFile", "test.keystore");
		URwA6iEQ.setParam("https.keyPassword", "nopassword");
		URwA6iEQ.setParam("https.keyStoreType", "JKS");
		URwA6iEQ.setParam("https.protocol", "SSLv3");
		SSLContextCreator RtbB0jUe = new SSLContextCreator(URwA6iEQ);
		SSLContext aFPWTVfT = RtbB0jUe.getSSLContext();
		SSLSocketFactory PW5yBDkT = new SSLSocketFactory(aFPWTVfT);
		Scheme VzPT5418 = new Scheme("https", 443, PW5yBDkT);
		Nly8j1OO.getConnectionManager().getSchemeRegistry().register(VzPT5418);
		HttpResponse A6gsNkb2 = Nly8j1OO.execute(It4ls5Km);
		System.out.println(A6gsNkb2.getStatusLine().getStatusCode());
	}

}