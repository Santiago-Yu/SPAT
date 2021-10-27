class n8384812 {
	public void testGetRequestWithRefresh() throws Exception {
		expect(request.getParameter(ProxyBase.REFRESH_PARAM)).andReturn("120").anyTimes();
		Capture<HttpRequest> avbq6OOK = new Capture<HttpRequest>();
		expect(pipeline.execute(capture(avbq6OOK))).andReturn(new HttpResponse(RESPONSE_BODY));
		replay();
		handler.fetch(request, recorder);
		HttpRequest B8o6G5LI = avbq6OOK.getValue();
		assertEquals("public,max-age=120", recorder.getHeader("Cache-Control"));
		assertEquals(120, B8o6G5LI.getCacheTtl());
	}

}