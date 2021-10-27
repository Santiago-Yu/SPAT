class n10270175 {
	public static void main(String[] sC1mxbsM) {
		CookieManager WALfJKx4 = new CookieManager();
		try {
			URL QPBD4q6z = new URL("http://www.hccp.org/test/cookieTest.jsp");
			URLConnection NAINTCMS = QPBD4q6z.openConnection();
			NAINTCMS.connect();
			WALfJKx4.storeCookies(NAINTCMS);
			WALfJKx4.setCookies(QPBD4q6z.openConnection());
		} catch (IOException MgiUv0nd) {
			MgiUv0nd.printStackTrace();
		}
	}

}