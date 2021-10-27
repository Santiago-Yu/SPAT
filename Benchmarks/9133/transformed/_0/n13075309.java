class n13075309 {
	public static void loginBayFiles() throws Exception {
		HttpParams y7F0XLFU = new BasicHttpParams();
		y7F0XLFU.setParameter("http.useragent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
		DefaultHttpClient D0U56yx2 = new DefaultHttpClient(y7F0XLFU);
		System.out.println("Trying to log in to bayfiles.com");
		HttpPost lNUuWXVz = new HttpPost("http://bayfiles.com/ajax_login");
		List<NameValuePair> ug4jKahx = new ArrayList<NameValuePair>();
		ug4jKahx.add(new BasicNameValuePair("action", "login"));
		ug4jKahx.add(new BasicNameValuePair("username", ""));
		ug4jKahx.add(new BasicNameValuePair("password", ""));
		UrlEncodedFormEntity xgiO9Npp = new UrlEncodedFormEntity(ug4jKahx, "UTF-8");
		lNUuWXVz.setEntity(xgiO9Npp);
		HttpResponse E7WSmTE3 = D0U56yx2.execute(lNUuWXVz);
		System.out.println("Getting cookies........");
		Iterator<Cookie> Qx1bNbX2 = D0U56yx2.getCookieStore().getCookies().iterator();
		Cookie oR56jBh4 = null;
		while (Qx1bNbX2.hasNext()) {
			oR56jBh4 = Qx1bNbX2.next();
			if (oR56jBh4.getName().equalsIgnoreCase("SESSID")) {
				sessioncookie = "SESSID=" + oR56jBh4.getValue();
				System.out.println(sessioncookie);
				login = true;
				System.out.println("BayFiles.com Login success :)");
			}
		}
		if (!login) {
			System.out.println("BayFiles.com Login failed :(");
		}
	}

}