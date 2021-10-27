class n8172652 {
	@Test
	@JUnitHttpServer(port = 10342, https = false, webapps = {
			@Webapp(context = "/fmpm", path = "src/test/resources/test-webapp") })
	public void testTestServlet() throws Exception {
		TestServlet.reset();
		HttpClient A7gNQbkg = new DefaultHttpClient();
		HttpEntity P64oMag7 = new StringEntity(xml);
		HttpPost s3dEPAho = new HttpPost("http://localhost:10342/fmpm/restful/NotificationMessageRelay");
		s3dEPAho.setEntity(P64oMag7);
		HttpResponse SG5Kd03u = A7gNQbkg.execute(s3dEPAho);
		assertEquals(200, SG5Kd03u.getStatusLine().getStatusCode());
		assertEquals(xml, TestServlet.getPosted());
	}

}