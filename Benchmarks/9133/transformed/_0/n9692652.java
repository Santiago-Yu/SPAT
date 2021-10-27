class n9692652 {
	public static void main(String[] peEniWBz) throws Exception {
		DefaultHttpClient naXAW90q = new DefaultHttpClient();
		HttpGet OjqgMAmr = new HttpGet("https://portal.sun.com/portal/dt");
		HttpResponse q1zS6CiE = naXAW90q.execute(OjqgMAmr);
		HttpEntity vW7908gV = q1zS6CiE.getEntity();
		System.out.println("Login form get: " + q1zS6CiE.getStatusLine());
		if (vW7908gV != null) {
			vW7908gV.consumeContent();
		}
		System.out.println("Initial set of cookies:");
		List<Cookie> p8YAuKAW = naXAW90q.getCookieStore().getCookies();
		if (p8YAuKAW.isEmpty()) {
			System.out.println("None");
		} else {
			for (int oLd1KA3Q = 0; oLd1KA3Q < p8YAuKAW.size(); oLd1KA3Q++) {
				System.out.println("- " + p8YAuKAW.get(oLd1KA3Q).toString());
			}
		}
		HttpPost e7w1Ihq6 = new HttpPost("https://portal.sun.com/amserver/UI/Login?" + "org=self_registered_users&"
				+ "goto=/portal/dt&" + "gotoOnFail=/portal/dt?error=true");
		List<NameValuePair> djdawni4 = new ArrayList<NameValuePair>();
		djdawni4.add(new BasicNameValuePair("IDToken1", "username"));
		djdawni4.add(new BasicNameValuePair("IDToken2", "password"));
		e7w1Ihq6.setEntity(new UrlEncodedFormEntity(djdawni4, HTTP.UTF_8));
		q1zS6CiE = naXAW90q.execute(e7w1Ihq6);
		vW7908gV = q1zS6CiE.getEntity();
		System.out.println("Login form get: " + q1zS6CiE.getStatusLine());
		if (vW7908gV != null) {
			vW7908gV.consumeContent();
		}
		System.out.println("Post logon cookies:");
		p8YAuKAW = naXAW90q.getCookieStore().getCookies();
		if (p8YAuKAW.isEmpty()) {
			System.out.println("None");
		} else {
			for (int DKrOoUPC = 0; DKrOoUPC < p8YAuKAW.size(); DKrOoUPC++) {
				System.out.println("- " + p8YAuKAW.get(DKrOoUPC).toString());
			}
		}
	}

}