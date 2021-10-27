class n9327524 {
	@Test
	public void test01_ok_failed_500() throws Exception {
		DefaultHttpClient TvYGMpdL = new DefaultHttpClient();
		try {
			HttpPost NnvPTxyg = new HttpPost(chartURL);
			HttpResponse fNDW3gwk = TvYGMpdL.execute(NnvPTxyg);
			assertEquals("failed code for ", 500, fNDW3gwk.getStatusLine().getStatusCode());
		} finally {
			TvYGMpdL.getConnectionManager().shutdown();
		}
	}

}