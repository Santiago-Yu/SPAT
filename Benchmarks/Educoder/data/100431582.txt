    @Test(expected = GadgetException.class)
    public void malformedGadgetSpecIsCachedAndThrows() throws Exception {
        HttpRequest request = createCacheableRequest();
        expect(pipeline.execute(request)).andReturn(new HttpResponse("malformed junk")).once();
        replay(pipeline);
        try {
            specFactory.getGadgetSpec(createContext(SPEC_URL, false));
            fail("No exception thrown on bad parse");
        } catch (GadgetException e) {
        }
        specFactory.getGadgetSpec(createContext(SPEC_URL, false));
    }
