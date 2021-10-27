class n8384812{
    public void testGetRequestWithRefresh() throws Exception {
        expect(request.getParameter(ProxyBase.REFRESH_PARAM)).andReturn("120").anyTimes();
        Capture<HttpRequest> requestCapture = new Capture<HttpRequest>();
        expect(pipeline.execute(capture(requestCapture))).andReturn(new HttpResponse(RESPONSE_BODY));
        replay();
        handler.fetch(request, recorder);
        HttpRequest httpRequest = requestCapture.getValue();
        assertEquals("public,max-age=120", recorder.getHeader("Cache-Control"));
        assertEquals(120, httpRequest.getCacheTtl());
    }

}