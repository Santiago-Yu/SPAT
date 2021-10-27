class n9830409 {
	@Test
	public final void testCheckCookies() {
		URL url = null;
		try {
			url = new URL("http://localhost:8080");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		StringBuffer content = new StringBuffer();
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)");
			cookie = connection.getHeaderField("Set-Cookie");
			if (cookie != null)
				System.out.println("cookie: " + cookie.toString());
			connection.setDoInput(true);
			InputStream is = connection.getInputStream();
			byte[] buffer = new byte[2048];
			int count;
			for (; -1 != (count = is.read(buffer));) {
				content.append(new String(buffer, 0, count));
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
			return;
		}
	}

}