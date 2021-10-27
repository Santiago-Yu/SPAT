class n2381661{
    @Test(expected = GadgetException.class)
    public void badFetchServesCached() throws Exception {
        HttpRequest firstRequest = createCacheableRequest();
        expect(pipeline.execute(firstRequest)).andReturn(new HttpResponse(LOCAL_SPEC_XML)).once();
        HttpRequest secondRequest = createIgnoreCacheRequest();
        expect(pipeline.execute(secondRequest)).andReturn(HttpResponse.error()).once();
        replay(pipeline);
        GadgetSpec original = specFactory.getGadgetSpec(createContext(SPEC_URL, false));
        GadgetSpec cached = specFactory.getGadgetSpec(createContext(SPEC_URL, true));
        assertEquals(original.getUrl(), cached.getUrl());
        assertEquals(original.getChecksum(), cached.getChecksum());
    }

}