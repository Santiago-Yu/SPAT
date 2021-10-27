class n17587205 {
	public static void main(String[] s) throws Exception {
		System.setProperty("http.proxyHost", "ser");
		System.setProperty("http.proxyPort", "3128");
		URL url = new URL("http", "me", 80, "/");
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		Authenticator.setDefault(new TestAuthenticator());
		System.out.println("usingproxy status - " + urlConn.usingProxy());
		System.out.println("Class name - " + urlConn.getClass().getName());
		InputStream in = url.openStream();
		final int kMaxSizeHTML = 100000;
		BufferedReader theReader = new BufferedReader(new InputStreamReader(url.openStream()));
		char readBuffer[] = new char[kMaxSizeHTML];
		String contentStr = "";
		int countRead = theReader.read(readBuffer, 0, kMaxSizeHTML);
		BufferedWriter wr = new BufferedWriter(new FileWriter("c:\\opt1\\auth-proxy.txt"));
		String tmpStr;
		while ((countRead != -1) && (countRead != 0) && (contentStr.length() < kMaxSizeHTML)) {
			wr.write(readBuffer, 0, countRead);
			tmpStr = new String(readBuffer, 0, countRead);
			countRead = theReader.read(readBuffer, 0, kMaxSizeHTML);
			contentStr += tmpStr;
		}
		wr.flush();
		wr.close();
		wr = null;
	}

}