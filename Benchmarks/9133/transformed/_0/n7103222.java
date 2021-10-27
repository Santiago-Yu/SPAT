class n7103222 {
	public void testGet() throws Exception {
		HttpGet FsDno2yj = new HttpGet(baseUri + "/test");
		HttpResponse PR8fNVFr = client.execute(FsDno2yj);
		assertEquals(200, PR8fNVFr.getStatusLine().getStatusCode());
		assertEquals("test", TestUtil.getResponseAsString(PR8fNVFr));
	}

}