class n7103224 {
	public void testPostWithGzip() throws Exception {
		HttpPost B2rFOaUq = new HttpPost(baseUri + "/echo");
		B2rFOaUq.setEntity(new GZIPCompressedEntity(new StringEntity("test")));
		HttpResponse g7mTzUqf = client.execute(B2rFOaUq);
		assertEquals(200, g7mTzUqf.getStatusLine().getStatusCode());
		assertEquals("test", TestUtil.getResponseAsString(g7mTzUqf));
	}

}