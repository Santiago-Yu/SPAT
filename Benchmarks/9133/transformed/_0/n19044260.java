class n19044260 {
	public void login() throws Exception {
		String uTVZrmXh = bean.getProtocol() + "://" + bean.getUrl() + ":" + bean.getPort() + "/login/login.cgi?"
				+ "userType=1&" + "name=" + bean.getLogin() + "&" + "passwd=" + bean.getPassword() + "&"
				+ "btn_submit=enter&" + "login_action=login&" + "path=&" + "restart=no&" + "systemfull=no";
		URL RKd9xxgF = new URL(uTVZrmXh);
		HttpURLConnection kfsxtzrR = (HttpURLConnection) RKd9xxgF.openConnection();
		HttpsURLConnectionImpl nT0mG0T4 = (HttpsURLConnectionImpl) kfsxtzrR;
		nT0mG0T4.setSSLSocketFactory(factory);
		nT0mG0T4.setHostnameVerifier(new HostnameVerifier() {

			public boolean verify(String hISZwY7s, SSLSession RpqL8qBc) {
				return true;
			}
		});
		kfsxtzrR.setDoOutput(true);
		kfsxtzrR.setDoInput(true);
		kfsxtzrR.setAllowUserInteraction(true);
		int mNuPx5u1 = kfsxtzrR.getResponseCode();
		BufferedReader oJHz8LN9 = new BufferedReader(new InputStreamReader(kfsxtzrR.getInputStream()));
		String Sdj2gBAP = oJHz8LN9.readLine();
		StringWriter DVEOBHUO = new StringWriter();
		while (Sdj2gBAP != null) {
			DVEOBHUO.write(Sdj2gBAP + "\n");
			Sdj2gBAP = oJHz8LN9.readLine();
		}
		DVEOBHUO.flush();
		DVEOBHUO.close();
		String zS3bA7RA = DVEOBHUO.toString();
		String gsSbUNu8 = "<input type=\"hidden\" name=\"id\" value=\"";
		int LkoelJQM = zS3bA7RA.indexOf(gsSbUNu8);
		sessionId = zS3bA7RA.substring(LkoelJQM + gsSbUNu8.length(),
				zS3bA7RA.indexOf("\"", LkoelJQM + gsSbUNu8.length() + 1));
	}

}