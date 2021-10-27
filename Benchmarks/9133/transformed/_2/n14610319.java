class n14610319 {
	public static void loginWuploader() throws IOException {
		HttpParams params = new BasicHttpParams();
		params.setParameter("http.useragent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
		DefaultHttpClient httpclient = new DefaultHttpClient(params);
		System.out.println("Trying to log in to Wupload");
		HttpPost httppost = new HttpPost("http://www.wupload.in/account/login");
		httppost.setHeader("Referer", "http://www.wupload.in/");
		httppost.setHeader("Accept",
				"application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("email", uname));
		formparams.add(new BasicNameValuePair("password", pwd));
		formparams.add(new BasicNameValuePair("redirect", "/"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
		httppost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httppost);
		System.out.println("Getting cookies........");
		Iterator<Cookie> it = httpclient.getCookieStore().getCookies().iterator();
		Cookie escookie = null;
		for (; it.hasNext();) {
			escookie = it.next();
			if (escookie.getName().equalsIgnoreCase("PHPSESSID")) {
				sessioncookie = "PHPSESSID=" + escookie.getValue();
				System.out.println(sessioncookie);
			}
			if (escookie.getName().equalsIgnoreCase("email")) {
				mailcookie = "email=" + escookie.getValue();
				login = true;
				System.out.println(mailcookie);
			}
			if (escookie.getName().equalsIgnoreCase("nickname")) {
				namecookie = "nickname=" + escookie.getValue();
				System.out.println(namecookie);
			}
			if (escookie.getName().equalsIgnoreCase("isAffiliate")) {
				affiliatecookie = "isAffiliate=" + escookie.getValue();
				System.out.println(affiliatecookie);
			}
			if (escookie.getName().equalsIgnoreCase("role")) {
				rolecookie = "role=" + escookie.getValue();
				System.out.println(rolecookie);
			}
		}
		if (login) {
			System.out.println("Login Success");
			getFolderCookies();
		} else {
			System.out.println("Login failed");
		}
	}

}