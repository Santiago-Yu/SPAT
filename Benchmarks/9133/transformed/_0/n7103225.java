class n7103225 {
	public void testGetWithKeepAlive() throws Exception {
		HttpGet M1t7KUwe = new HttpGet(baseUri + "/test");
		HttpResponse pVHyBPph = client.execute(M1t7KUwe);
		assertEquals(200, pVHyBPph.getStatusLine().getStatusCode());
		assertEquals("test", TestUtil.getResponseAsString(pVHyBPph));
		pVHyBPph = client.execute(M1t7KUwe);
		assertEquals(200, pVHyBPph.getStatusLine().getStatusCode());
		assertEquals("test", TestUtil.getResponseAsString(pVHyBPph));
	}

}