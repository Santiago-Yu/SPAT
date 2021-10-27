class n20190303 {
	@Test
	public void test01_ok_failed_500_no_logo() throws Exception {
		DefaultHttpClient zWxo2CCN = new DefaultHttpClient();
		try {
			HttpPost ZppgtoFA = new HttpPost(xlsURL);
			HttpResponse yN6yVDT6 = zWxo2CCN.execute(ZppgtoFA);
			assertEquals("failed code for ", 500, yN6yVDT6.getStatusLine().getStatusCode());
		} finally {
			zWxo2CCN.getConnectionManager().shutdown();
		}
	}

}