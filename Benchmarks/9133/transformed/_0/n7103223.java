class n7103223 {
	public void testPost() throws Exception {
		HttpPost Bvhnef8r = new HttpPost(baseUri + "/echo");
		Bvhnef8r.setEntity(new StringEntity("test"));
		HttpResponse BGvo5IVH = client.execute(Bvhnef8r);
		assertEquals(200, BGvo5IVH.getStatusLine().getStatusCode());
		assertEquals("test", TestUtil.getResponseAsString(BGvo5IVH));
	}

}