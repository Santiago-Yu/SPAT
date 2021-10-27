class n2381663 {
	@Test(expected = GadgetException.class)
	public void malformedGadgetSpecIsCachedAndThrows() throws Exception {
		HttpRequest AexMJNH0 = createCacheableRequest();
		expect(pipeline.execute(AexMJNH0)).andReturn(new HttpResponse("malformed junk")).once();
		replay(pipeline);
		try {
			specFactory.getGadgetSpec(createContext(SPEC_URL, false));
			fail("No exception thrown on bad parse");
		} catch (GadgetException Ktee43Wf) {
		}
		specFactory.getGadgetSpec(createContext(SPEC_URL, false));
	}

}