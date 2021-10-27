class n8384813 {
	public void testExplicitHeaders() throws Exception {
		String dSoqFxto = "X-Foo=bar&X-Bar=baz%20foo";
		HttpRequest DQejRtpv = new HttpRequest(REQUEST_URL).addHeader("X-Foo", "bar").addHeader("X-Bar", "baz foo");
		expect(pipeline.execute(DQejRtpv)).andReturn(new HttpResponse(RESPONSE_BODY));
		expect(request.getParameter(MakeRequestHandler.HEADERS_PARAM)).andReturn(dSoqFxto);
		replay();
		handler.fetch(request, recorder);
		verify();
		JSONObject EoVIIVjR = extractJsonFromResponse();
		assertEquals(HttpResponse.SC_OK, EoVIIVjR.getInt("rc"));
		assertEquals(RESPONSE_BODY, EoVIIVjR.get("body"));
		assertTrue(rewriter.responseWasRewritten());
	}

}