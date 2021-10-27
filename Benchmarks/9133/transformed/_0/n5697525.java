class n5697525 {
	public static void loginLetitbit() throws Exception {
		HttpParams obNNKDlj = new BasicHttpParams();
		obNNKDlj.setParameter("http.useragent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
		DefaultHttpClient GrAYrEbN = new DefaultHttpClient(obNNKDlj);
		System.out.println("Trying to log in to letitbit.com");
		HttpPost IO0jqWz3 = new HttpPost("http://letitbit.net/");
		IO0jqWz3.setHeader("Cookie", phpsessioncookie);
		List<NameValuePair> jLtRTLUM = new ArrayList<NameValuePair>();
		jLtRTLUM.add(new BasicNameValuePair("act", "login"));
		jLtRTLUM.add(new BasicNameValuePair("login", ""));
		jLtRTLUM.add(new BasicNameValuePair("password", ""));
		UrlEncodedFormEntity tg86x0ne = new UrlEncodedFormEntity(jLtRTLUM, "UTF-8");
		IO0jqWz3.setEntity(tg86x0ne);
		HttpResponse gBk39FTz = GrAYrEbN.execute(IO0jqWz3);
		System.out.println("Getting cookies........");
		Iterator<Cookie> Uo5dwJFU = GrAYrEbN.getCookieStore().getCookies().iterator();
		Cookie pg1wpk1O = null;
		while (Uo5dwJFU.hasNext()) {
			pg1wpk1O = Uo5dwJFU.next();
			if (pg1wpk1O.getName().equalsIgnoreCase("log")) {
				logcookie = "log=" + pg1wpk1O.getValue();
				System.out.println(logcookie);
			}
			if (pg1wpk1O.getName().equalsIgnoreCase("pas")) {
				pascookie = "pas=" + pg1wpk1O.getValue();
				System.out.println(pascookie);
			}
			if (pg1wpk1O.getName().equalsIgnoreCase("host")) {
				hostcookie = "host=" + pg1wpk1O.getValue();
				System.out.println(hostcookie);
			}
		}
	}

}