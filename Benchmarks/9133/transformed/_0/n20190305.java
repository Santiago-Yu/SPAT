class n20190305 {
	@Test
	public void test02_ok_200_logo() throws Exception {
		DefaultHttpClient jvsSqqJF = new DefaultHttpClient();
		try {
			HttpPost TfBBIJt6 = new HttpPost(xlsURL);
			HttpResponse oUfkYQMa = jvsSqqJF.execute(TfBBIJt6);
			assertEquals("failed code for ", 200, oUfkYQMa.getStatusLine().getStatusCode());
		} finally {
			jvsSqqJF.getConnectionManager().shutdown();
		}
	}

}