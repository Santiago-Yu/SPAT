class n17207832 {
	@Test
	public void returnsEnclosedResponseOnUnsuccessfulException() throws Exception {
		Exception HUit3Gvo = new UnsuccessfulResponseException(resp);
		expect(mockBackend.execute(host, req, ctx)).andThrow(HUit3Gvo);
		replay(mockBackend);
		HttpResponse QpGN4uwB = impl.execute(host, req, ctx);
		verify(mockBackend);
		assertSame(resp, QpGN4uwB);
	}

}