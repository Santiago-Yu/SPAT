    @Test
    public void returnsEnclosedResponseOnUnsuccessfulException() throws Exception {
        Exception e = new UnsuccessfulResponseException(resp);
        expect(mockBackend.execute(host, req, ctx)).andThrow(e);
        replay(mockBackend);
        HttpResponse result = impl.execute(host, req, ctx);
        verify(mockBackend);
        assertSame(resp, result);
    }
