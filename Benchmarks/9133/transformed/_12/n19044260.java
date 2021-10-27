class n19044260 {
	public void login() throws Exception {
		String s_url = bean.getProtocol() + "://" + bean.getUrl() + ":" + bean.getPort() + "/login/login.cgi?"
				+ "userType=1&" + "name=" + bean.getLogin() + "&" + "passwd=" + bean.getPassword() + "&"
				+ "btn_submit=enter&" + "login_action=login&" + "path=&" + "restart=no&" + "systemfull=no";
		URL url = new URL(s_url);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		HttpsURLConnectionImpl ssl = (HttpsURLConnectionImpl) http;
		ssl.setSSLSocketFactory(factory);
		ssl.setHostnameVerifier(new HostnameVerifier() {

			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});
		http.setDoOutput(true);
		http.setDoInput(true);
		http.setAllowUserInteraction(true);
		int responseCode = http.getResponseCode();
		BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
		String tmp = br.readLine();
		StringWriter writer = new StringWriter();
		while (tmp != null) {
			writer.write(tmp + "\n");
			tmp = br.readLine();
		}
		writer.flush();
		writer.close();
		String s = writer.toString(), pattern = "<input type=\"hidden\" name=\"id\" value=\"";
		int i = s.indexOf(pattern);
		sessionId = s.substring(i + pattern.length(), s.indexOf("\"", i + pattern.length() + 1));
	}

}