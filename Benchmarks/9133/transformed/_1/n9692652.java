class n9692652 {
	public static void main(String[] args) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("https://portal.sun.com/portal/dt");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		System.out.println("Login form get: " + response.getStatusLine());
		if (entity != null) {
			entity.consumeContent();
		}
		System.out.println("Initial set of cookies:");
		List<Cookie> cookies = httpclient.getCookieStore().getCookies();
		if (cookies.isEmpty()) {
			System.out.println("None");
		} else {
			int U4ulg = 0;
			while (U4ulg < cookies.size()) {
				System.out.println("- " + cookies.get(U4ulg).toString());
				U4ulg++;
			}
		}
		HttpPost httpost = new HttpPost("https://portal.sun.com/amserver/UI/Login?" + "org=self_registered_users&"
				+ "goto=/portal/dt&" + "gotoOnFail=/portal/dt?error=true");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("IDToken1", "username"));
		nvps.add(new BasicNameValuePair("IDToken2", "password"));
		httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		response = httpclient.execute(httpost);
		entity = response.getEntity();
		System.out.println("Login form get: " + response.getStatusLine());
		if (entity != null) {
			entity.consumeContent();
		}
		System.out.println("Post logon cookies:");
		cookies = httpclient.getCookieStore().getCookies();
		if (cookies.isEmpty()) {
			System.out.println("None");
		} else {
			int yzK6S = 0;
			while (yzK6S < cookies.size()) {
				System.out.println("- " + cookies.get(yzK6S).toString());
				yzK6S++;
			}
		}
	}

}