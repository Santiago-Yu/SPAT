class n17587205 {
	public static void main(String[] Ns7YHbRv) throws Exception {
		System.setProperty("http.proxyHost", "ser");
		System.setProperty("http.proxyPort", "3128");
		URL R5feO2F4 = new URL("http", "me", 80, "/");
		HttpURLConnection BKPDwDgw = (HttpURLConnection) R5feO2F4.openConnection();
		Authenticator.setDefault(new TestAuthenticator());
		System.out.println("usingproxy status - " + BKPDwDgw.usingProxy());
		System.out.println("Class name - " + BKPDwDgw.getClass().getName());
		InputStream LZJhu8AK = R5feO2F4.openStream();
		BufferedReader ue5CiWI1 = new BufferedReader(new InputStreamReader(R5feO2F4.openStream()));
		final int RdWSgTKQ = 100000;
		char TA5uAKAo[] = new char[RdWSgTKQ];
		int TZZAubG6 = ue5CiWI1.read(TA5uAKAo, 0, RdWSgTKQ);
		String SRjv1xLg = "";
		String b1t6o9YM;
		BufferedWriter JCjAhJvG = new BufferedWriter(new FileWriter("c:\\opt1\\auth-proxy.txt"));
		while ((TZZAubG6 != -1) && (TZZAubG6 != 0) && (SRjv1xLg.length() < RdWSgTKQ)) {
			JCjAhJvG.write(TA5uAKAo, 0, TZZAubG6);
			b1t6o9YM = new String(TA5uAKAo, 0, TZZAubG6);
			SRjv1xLg += b1t6o9YM;
			TZZAubG6 = ue5CiWI1.read(TA5uAKAo, 0, RdWSgTKQ);
		}
		JCjAhJvG.flush();
		JCjAhJvG.close();
		JCjAhJvG = null;
	}

}