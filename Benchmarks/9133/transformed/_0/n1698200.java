class n1698200 {
	public static void loginBitShare() throws Exception {
		HttpParams tEdLA9Lj = new BasicHttpParams();
		tEdLA9Lj.setParameter("http.useragent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
		DefaultHttpClient nZfdQRgw = new DefaultHttpClient(tEdLA9Lj);
		System.out.println("Trying to log in to bitshare.com");
		HttpPost vgZFFPMD = new HttpPost("http://bitshare.com/login.html");
		List<NameValuePair> VMDBRb82 = new ArrayList<NameValuePair>();
		VMDBRb82.add(new BasicNameValuePair("user", "007007dinesh"));
		VMDBRb82.add(new BasicNameValuePair("password", ""));
		VMDBRb82.add(new BasicNameValuePair("submit", "Login"));
		UrlEncodedFormEntity sXaNG1LT = new UrlEncodedFormEntity(VMDBRb82, "UTF-8");
		vgZFFPMD.setEntity(sXaNG1LT);
		HttpResponse sU6lQVRI = nZfdQRgw.execute(vgZFFPMD);
		Iterator<Cookie> mLzwU471 = nZfdQRgw.getCookieStore().getCookies().iterator();
		Cookie i72FDWDC = null;
		while (mLzwU471.hasNext()) {
			i72FDWDC = mLzwU471.next();
			System.out.println(i72FDWDC.getName() + " = " + i72FDWDC.getValue());
		}
		System.out.println(EntityUtils.toString(sU6lQVRI.getEntity()));
	}

}