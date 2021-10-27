class n5697525 {
	public static void loginLetitbit() throws Exception {
		HttpParams params = new BasicHttpParams();
		params.setParameter("http.useragent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
		DefaultHttpClient httpclient = new DefaultHttpClient(params);
		System.out.println("Trying to log in to letitbit.com");
		HttpPost httppost = new HttpPost("http://letitbit.net/");
		httppost.setHeader("Cookie", phpsessioncookie);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("act", "login"));
		formparams.add(new BasicNameValuePair("login", ""));
		formparams.add(new BasicNameValuePair("password", ""));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
		httppost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httppost);
		System.out.println("Getting cookies........");
		Iterator<Cookie> it = httpclient.getCookieStore().getCookies().iterator();
		Cookie escookie = null;
		for (; it.hasNext();) {
			escookie = it.next();
			if (escookie.getName().equalsIgnoreCase("log")) {
				logcookie = "log=" + escookie.getValue();
				System.out.println(logcookie);
			}
			if (escookie.getName().equalsIgnoreCase("pas")) {
				pascookie = "pas=" + escookie.getValue();
				System.out.println(pascookie);
			}
			if (escookie.getName().equalsIgnoreCase("host")) {
				hostcookie = "host=" + escookie.getValue();
				System.out.println(hostcookie);
			}
		}
	}

}