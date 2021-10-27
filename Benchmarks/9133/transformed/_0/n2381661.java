class n2381661 {
	@Test(expected = GadgetException.class)
	public void badFetchServesCached() throws Exception {
		HttpRequest apTg77g3 = createCacheableRequest();
		expect(pipeline.execute(apTg77g3)).andReturn(new HttpResponse(LOCAL_SPEC_XML)).once();
		HttpRequest kGk8LLbe = createIgnoreCacheRequest();
		expect(pipeline.execute(kGk8LLbe)).andReturn(HttpResponse.error()).once();
		replay(pipeline);
		GadgetSpec elvsqxTR = specFactory.getGadgetSpec(createContext(SPEC_URL, false));
		GadgetSpec Ar3si9qs = specFactory.getGadgetSpec(createContext(SPEC_URL, true));
		assertEquals(elvsqxTR.getUrl(), Ar3si9qs.getUrl());
		assertEquals(elvsqxTR.getChecksum(), Ar3si9qs.getChecksum());
	}

}