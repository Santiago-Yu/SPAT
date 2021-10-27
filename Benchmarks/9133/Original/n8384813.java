class n8384813{
    public void testExplicitHeaders() throws Exception {
        String headerString = "X-Foo=bar&X-Bar=baz%20foo";
        HttpRequest expected = new HttpRequest(REQUEST_URL).addHeader("X-Foo", "bar").addHeader("X-Bar", "baz foo");
        expect(pipeline.execute(expected)).andReturn(new HttpResponse(RESPONSE_BODY));
        expect(request.getParameter(MakeRequestHandler.HEADERS_PARAM)).andReturn(headerString);
        replay();
        handler.fetch(request, recorder);
        verify();
        JSONObject results = extractJsonFromResponse();
        assertEquals(HttpResponse.SC_OK, results.getInt("rc"));
        assertEquals(RESPONSE_BODY, results.get("body"));
        assertTrue(rewriter.responseWasRewritten());
    }

}