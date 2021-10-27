class n9830409 {
	@Test
	public final void testCheckCookies() {
		URL uLLmG3UU = null;
		try {
			uLLmG3UU = new URL("http://localhost:8080");
		} catch (MalformedURLException CNz2Rn3S) {
			CNz2Rn3S.printStackTrace();
		}
		StringBuffer Pwcljhlp = new StringBuffer();
		try {
			HttpURLConnection wqAEjIaF = (HttpURLConnection) uLLmG3UU.openConnection();
			wqAEjIaF.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)");
			cookie = wqAEjIaF.getHeaderField("Set-Cookie");
			if (cookie != null)
				System.out.println("cookie: " + cookie.toString());
			wqAEjIaF.setDoInput(true);
			InputStream Ew3ShFFR = wqAEjIaF.getInputStream();
			byte[] Obir8boC = new byte[2048];
			int y1ptSy79;
			while (-1 != (y1ptSy79 = Ew3ShFFR.read(Obir8boC))) {
				Pwcljhlp.append(new String(Obir8boC, 0, y1ptSy79));
			}
		} catch (IOException EgRGI5GT) {
			System.out.print(EgRGI5GT.getMessage());
			return;
		}
	}

}