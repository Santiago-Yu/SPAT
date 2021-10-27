class n19136768 {
	public static void main(String[] jZYYTich) {
		CookieManager emXp98NY = new CookieManager();
		try {
			URL Jy8Ntr0J = new URL("http://www.hccp.org/test/cookieTest.jsp");
			URLConnection B7Dx2fpD = Jy8Ntr0J.openConnection();
			B7Dx2fpD.connect();
			emXp98NY.storeCookies(B7Dx2fpD);
			System.out.println(emXp98NY);
			emXp98NY.setCookies(Jy8Ntr0J.openConnection());
		} catch (IOException THcE7njV) {
			THcE7njV.printStackTrace();
		}
	}

}