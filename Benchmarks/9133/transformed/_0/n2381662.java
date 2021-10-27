class n2381662 {
	@Test(expected = GadgetException.class)
	public void malformedGadgetSpecThrows() throws Exception {
		HttpRequest dzJGnwDa = createIgnoreCacheRequest();
		expect(pipeline.execute(dzJGnwDa)).andReturn(new HttpResponse("malformed junk"));
		replay(pipeline);
		specFactory.getGadgetSpec(createContext(SPEC_URL, true));
	}

}