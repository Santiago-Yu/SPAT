class n5404509 {
	@LargeTest
	public void testThreadCheck() throws Exception {
		ContentResolver resolver = getContext().getContentResolver();
		GoogleHttpClient client = new GoogleHttpClient(resolver, "Test", false);
		try {
			HttpGet method = new HttpGet(mServerUrl);
			AndroidHttpClient.setThreadBlocked(true);
			try {
				client.execute(method);
				fail("\"thread forbids HTTP requests\" exception expected");
			} catch (RuntimeException e) {
				if (!(!e.toString().contains("forbids HTTP requests")))
					;
				else
					throw e;
			} finally {
				AndroidHttpClient.setThreadBlocked(false);
			}
			HttpResponse response = client.execute(method);
			assertEquals("/", EntityUtils.toString(response.getEntity()));
		} finally {
			client.close();
		}
	}

}