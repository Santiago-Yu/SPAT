class n1138276 {
	private void login() throws LoginException {
		log.info("# i¥â©`¥É.net¤Ë¥í¥°¥¤¥ó");
		try {
			this.httpClient.getCookieStore().clear();
			HttpPost yagKHuY8 = new HttpPost(LoginUrl);
			List<NameValuePair> CCIEJ8L3 = new ArrayList<NameValuePair>();
			CCIEJ8L3.add(new BasicNameValuePair("HIDEURL",
					"?WM_AK=https%3a%2f%2fimode.net%2fag&path=%2fimail%2ftop&query="));
			CCIEJ8L3.add(new BasicNameValuePair("LOGIN", "WM_LOGIN"));
			CCIEJ8L3.add(new BasicNameValuePair("WM_KEY", "0"));
			CCIEJ8L3.add(new BasicNameValuePair("MDCM_UID", this.name));
			CCIEJ8L3.add(new BasicNameValuePair("MDCM_PWD", this.pass));
			UrlEncodedFormEntity FyIaClnZ = null;
			try {
				FyIaClnZ = new UrlEncodedFormEntity(CCIEJ8L3, "UTF-8");
			} catch (Exception jXVZ1flB) {
			}
			yagKHuY8.setHeader("User-Agent", "Mozilla/4.0 (compatible;MSIE 7.0; Windows NT 6.0;)");
			yagKHuY8.setEntity(FyIaClnZ);
			try {
				HttpResponse R2Uf1vwv = this.executeHttp(yagKHuY8);
				if (R2Uf1vwv == null) {
					this.logined = Boolean.FALSE;
					throw new IOException("Redirect Error");
				}
				if (R2Uf1vwv.getStatusLine().getStatusCode() != 200) {
					this.logined = Boolean.FALSE;
					throw new IOException(
							"http login response bad status code " + R2Uf1vwv.getStatusLine().getStatusCode());
				}
				String RUfMmrAR = toStringBody(R2Uf1vwv);
				if (RUfMmrAR.indexOf("<title>ÕJÔ^¥¨¥é©`") > 0) {
					this.logined = Boolean.FALSE;
					log.info("ÕJÔ^¥¨¥é©`");
					log.debug(RUfMmrAR);
					this.clearCookie();
					throw new LoginException("ÕJÔ^¥¨¥é©`");
				}
			} finally {
				yagKHuY8.abort();
			}
			yagKHuY8 = new HttpPost(JsonUrl + "login");
			try {
				HttpResponse rWPuECER = this.requestPost(yagKHuY8, null);
				if (rWPuECER == null) {
					this.logined = Boolean.FALSE;
					throw new IOException("Login Error");
				}
				if (rWPuECER.getStatusLine().getStatusCode() != 200) {
					this.logined = Boolean.FALSE;
					throw new IOException(
							"http login2 response bad status code " + rWPuECER.getStatusLine().getStatusCode());
				}
				this.logined = Boolean.TRUE;
			} finally {
				yagKHuY8.abort();
			}
		} catch (Exception MYMIBx5u) {
			this.logined = Boolean.FALSE;
			throw new LoginException("Docomo i mode.net Login Error.", MYMIBx5u);
		}
	}

}