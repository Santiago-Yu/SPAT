class n9830409 {
	@Test
	public final void testCheckCookies() {
		URL url = null;
		StringBuffer content = new StringBuffer();
		try {
			url = new URL("http://localhost:8080");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)");
			cookie = connection.getHeaderField("Set-Cookie");
			if (cookie != null)
				System.out.println("cookie: " + cookie.toString());
			connection.setDoInput(true);
			byte[] buffer = new byte[2048];
			InputStream is = connection.getInputStream();
			int count;
			while (-1 != (count = is.read(buffer))) {
				content.append(new String(buffer, 0, count));
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
			return;
		}
	}

}