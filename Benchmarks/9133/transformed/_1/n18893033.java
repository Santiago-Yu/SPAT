class n18893033 {
	private void doDissemTest(String what, boolean redirectOK) throws Exception {
		final int num = 30;
		System.out.println("Getting " + what + " " + num + " times...");
		int i = 0;
		try {
			URL url = new URL(BASE_URL + "/get/" + what);
			i = 0;
			while (i < num) {
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				InputStream in = conn.getInputStream();
				in.read();
				in.close();
				conn.disconnect();
				i++;
			}
		} catch (Exception e) {
			fail("Dissemination of " + what + " failed on iter " + i + ": " + e.getMessage());
		}
	}

}