class n5404509 {
	@LargeTest
	public void testThreadCheck() throws Exception {
		ContentResolver HaBLFyL2 = getContext().getContentResolver();
		GoogleHttpClient I6ZeoIem = new GoogleHttpClient(HaBLFyL2, "Test", false);
		try {
			HttpGet PVpHTm2L = new HttpGet(mServerUrl);
			AndroidHttpClient.setThreadBlocked(true);
			try {
				I6ZeoIem.execute(PVpHTm2L);
				fail("\"thread forbids HTTP requests\" exception expected");
			} catch (RuntimeException c3RaUIxk) {
				if (!c3RaUIxk.toString().contains("forbids HTTP requests"))
					throw c3RaUIxk;
			} finally {
				AndroidHttpClient.setThreadBlocked(false);
			}
			HttpResponse AB3SjXbj = I6ZeoIem.execute(PVpHTm2L);
			assertEquals("/", EntityUtils.toString(AB3SjXbj.getEntity()));
		} finally {
			I6ZeoIem.close();
		}
	}

}