class n20655776 {
	public static void loginLocalhostr() throws IOException {
		HttpParams Th3bzE6y = new BasicHttpParams();
		Th3bzE6y.setParameter("http.useragent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
		httpclient = new DefaultHttpClient(Th3bzE6y);
		System.out.println("Trying to log in to localhostr");
		HttpPost AQXwPfO8 = new HttpPost("http://localhostr.com/signin");
		AQXwPfO8.setHeader("Referer", "http://www.localhostr.com/");
		AQXwPfO8.setHeader("Accept",
				"application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
		List<NameValuePair> uZeX2c59 = new ArrayList<NameValuePair>();
		uZeX2c59.add(new BasicNameValuePair("username", "007007dinesh@gmail.com"));
		uZeX2c59.add(new BasicNameValuePair("password", ""));
		UrlEncodedFormEntity okGwvQOb = new UrlEncodedFormEntity(uZeX2c59, "UTF-8");
		AQXwPfO8.setEntity(okGwvQOb);
		HttpResponse GyPzZZLY = httpclient.execute(AQXwPfO8);
		System.out.println("Getting cookies........");
		System.out.println(GyPzZZLY.getStatusLine());
		Iterator<Cookie> UUSG4Hcz = httpclient.getCookieStore().getCookies().iterator();
		Cookie wEVtsKeT = null;
		while (UUSG4Hcz.hasNext()) {
			wEVtsKeT = UUSG4Hcz.next();
			if (wEVtsKeT.getName().contains("session")) {
				sessioncookie = wEVtsKeT.getName() + " = " + wEVtsKeT.getValue();
				System.out.println("session cookie : " + sessioncookie);
			}
		}
		if (GyPzZZLY.getStatusLine().getStatusCode() == 302) {
			login = true;
			System.out.println("localhostr Login Success");
		} else {
			System.out.println("localhostr Login failed");
		}
		System.out.println(EntityUtils.toString(GyPzZZLY.getEntity()));
		InputStream GVpcWrlT = GyPzZZLY.getEntity().getContent();
		GVpcWrlT.close();
	}

}