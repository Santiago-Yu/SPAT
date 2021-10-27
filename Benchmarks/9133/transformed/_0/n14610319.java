class n14610319 {
	public static void loginWuploader() throws IOException {
		HttpParams G8Pl3hKZ = new BasicHttpParams();
		G8Pl3hKZ.setParameter("http.useragent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
		DefaultHttpClient TqtXG65J = new DefaultHttpClient(G8Pl3hKZ);
		System.out.println("Trying to log in to Wupload");
		HttpPost BVBvsKFP = new HttpPost("http://www.wupload.in/account/login");
		BVBvsKFP.setHeader("Referer", "http://www.wupload.in/");
		BVBvsKFP.setHeader("Accept",
				"application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
		List<NameValuePair> NiPfXCAQ = new ArrayList<NameValuePair>();
		NiPfXCAQ.add(new BasicNameValuePair("email", uname));
		NiPfXCAQ.add(new BasicNameValuePair("password", pwd));
		NiPfXCAQ.add(new BasicNameValuePair("redirect", "/"));
		UrlEncodedFormEntity GE4Et3Pd = new UrlEncodedFormEntity(NiPfXCAQ, "UTF-8");
		BVBvsKFP.setEntity(GE4Et3Pd);
		HttpResponse sPpmjGuA = TqtXG65J.execute(BVBvsKFP);
		System.out.println("Getting cookies........");
		Iterator<Cookie> pq4UYQC7 = TqtXG65J.getCookieStore().getCookies().iterator();
		Cookie TQQJ7UOG = null;
		while (pq4UYQC7.hasNext()) {
			TQQJ7UOG = pq4UYQC7.next();
			if (TQQJ7UOG.getName().equalsIgnoreCase("PHPSESSID")) {
				sessioncookie = "PHPSESSID=" + TQQJ7UOG.getValue();
				System.out.println(sessioncookie);
			}
			if (TQQJ7UOG.getName().equalsIgnoreCase("email")) {
				mailcookie = "email=" + TQQJ7UOG.getValue();
				login = true;
				System.out.println(mailcookie);
			}
			if (TQQJ7UOG.getName().equalsIgnoreCase("nickname")) {
				namecookie = "nickname=" + TQQJ7UOG.getValue();
				System.out.println(namecookie);
			}
			if (TQQJ7UOG.getName().equalsIgnoreCase("isAffiliate")) {
				affiliatecookie = "isAffiliate=" + TQQJ7UOG.getValue();
				System.out.println(affiliatecookie);
			}
			if (TQQJ7UOG.getName().equalsIgnoreCase("role")) {
				rolecookie = "role=" + TQQJ7UOG.getValue();
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