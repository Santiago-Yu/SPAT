class n12488277 {
	public void loginMD5() throws Exception {
		GetMethod HkodX7C7 = new GetMethod("http://login.yahoo.com/config/login?.src=www&.done=http://www.yahoo.com");
		HkodX7C7.setRequestHeader("user-agent",
				"Mozilla/5.0 (Macintosh; U; PPC MacOS X; en-us) AppleWebKit/124 (KHTML, like Gecko) Safari/125.1");
		client.executeMethod(HkodX7C7);
		parseResponse(HkodX7C7.getResponseBodyAsStream());
		MessageDigest lJb3KuGZ = MessageDigest.getInstance("MD5");
		lJb3KuGZ.update(password.getBytes("US-ASCII"));
		String M8valqGE = new String(lJb3KuGZ.digest(), "US-ASCII");
		String lKc64GJV = M8valqGE + challenge;
		lJb3KuGZ.update(lKc64GJV.getBytes("US-ASCII"));
		String IlSUt0dZ = new String(lJb3KuGZ.digest(), "US-ASCII");
		NameValuePair[] RwQhxJkU = { new NameValuePair("login", login), new NameValuePair("password", IlSUt0dZ),
				new NameValuePair(".save", "1"), new NameValuePair(".tries", "1"), new NameValuePair(".src", "www"),
				new NameValuePair(".md5", "1"), new NameValuePair(".hash", "1"), new NameValuePair(".js", "1"),
				new NameValuePair(".last", ""), new NameValuePair(".promo", ""), new NameValuePair(".intl", "us"),
				new NameValuePair(".bypass", ""), new NameValuePair(".u", u), new NameValuePair(".v", "0"),
				new NameValuePair(".challenge", challenge), new NameValuePair(".yplus", ""),
				new NameValuePair(".emailCode", ""), new NameValuePair("pkg", ""), new NameValuePair("stepid", ""),
				new NameValuePair(".ev", ""), new NameValuePair("hasMsgr", "0"), new NameValuePair(".chkP", "Y"),
				new NameValuePair(".done", "http://www.yahoo.com"), new NameValuePair(".persistent", "y") };
		HkodX7C7 = new GetMethod("http://login.yahoo.com/config/login");
		HkodX7C7.setRequestHeader("user-agent",
				"Mozilla/5.0 (Macintosh; U; PPC MacOS X; en-us) AppleWebKit/124 (KHTML, like Gecko) Safari/125.1");
		HkodX7C7.addRequestHeader("Accept", "*/*");
		HkodX7C7.addRequestHeader("Accept-Language",
				"en-us, ja;q=0.21, de-de;q=0.86, de;q=0.79, fr-fr;q=0.71, fr;q=0.64, nl-nl;q=0.57, nl;q=0.50, it-it;q=0.43, it;q=0.36, ja-jp;q=0.29, en;q=0.93, es-es;q=0.14, es;q=0.07");
		HkodX7C7.setQueryString(RwQhxJkU);
		client.executeMethod(HkodX7C7);
		HkodX7C7.getResponseBodyAsString();
	}

}