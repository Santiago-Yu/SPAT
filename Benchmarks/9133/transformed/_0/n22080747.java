class n22080747 {
	@Test
	public void testCustomerResource() throws Exception {
		DefaultHttpClient ClmmvqdP = new DefaultHttpClient();
		System.out.println("**** CustomerResource No Query params ***");
		HttpGet B1ke5JV2 = new HttpGet("http://localhost:9095/customers");
		HttpResponse Bj60wG29 = ClmmvqdP.execute(B1ke5JV2);
		Assert.assertEquals(200, Bj60wG29.getStatusLine().getStatusCode());
		BufferedReader KQUOargm = new BufferedReader(new InputStreamReader(Bj60wG29.getEntity().getContent()));
		String B03TJxrj = KQUOargm.readLine();
		while (B03TJxrj != null) {
			System.out.println(B03TJxrj);
			B03TJxrj = KQUOargm.readLine();
		}
		System.out.println("**** CustomerResource With Query params ***");
		B1ke5JV2 = new HttpGet("http://localhost:9095/customers?start=1&size=3");
		Bj60wG29 = ClmmvqdP.execute(B1ke5JV2);
		Assert.assertEquals(200, Bj60wG29.getStatusLine().getStatusCode());
		KQUOargm = new BufferedReader(new InputStreamReader(Bj60wG29.getEntity().getContent()));
		B03TJxrj = KQUOargm.readLine();
		while (B03TJxrj != null) {
			System.out.println(B03TJxrj);
			B03TJxrj = KQUOargm.readLine();
		}
		System.out.println("**** CustomerResource With UriInfo and Query params ***");
		B1ke5JV2 = new HttpGet("http://localhost:9095/customers/uriinfo?start=2&size=2");
		Bj60wG29 = ClmmvqdP.execute(B1ke5JV2);
		Assert.assertEquals(200, Bj60wG29.getStatusLine().getStatusCode());
		KQUOargm = new BufferedReader(new InputStreamReader(Bj60wG29.getEntity().getContent()));
		B03TJxrj = KQUOargm.readLine();
		while (B03TJxrj != null) {
			System.out.println(B03TJxrj);
			B03TJxrj = KQUOargm.readLine();
		}
	}

}