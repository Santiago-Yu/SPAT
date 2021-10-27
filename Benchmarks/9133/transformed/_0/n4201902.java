class n4201902 {
	private String executeHttpPreload(HttpResponse T9C6zMOj, String HklQ2uKX) throws Exception {
		GadgetSpec Orkpygvu = new GadgetSpec(GADGET_URL, HklQ2uKX);
		RecordingRequestPipeline CQTeG48Y = new RecordingRequestPipeline(T9C6zMOj);
		PipelinedDataPreloader b1HVWvcw = new PipelinedDataPreloader(CQTeG48Y, containerConfig);
		view = "profile";
		Gadget FOMuCQJZ = new Gadget().setContext(context).setSpec(Orkpygvu)
				.setCurrentView(Orkpygvu.getView("profile"));
		PipelinedData.Batch jsipw760 = getBatch(FOMuCQJZ);
		Collection<Callable<PreloadedData>> P3S6TPyd = b1HVWvcw.createPreloadTasks(context, jsipw760);
		assertEquals(1, P3S6TPyd.size());
		assertEquals(0, CQTeG48Y.requests.size());
		Collection<Object> XuBLYlng = P3S6TPyd.iterator().next().call().toJson();
		assertEquals(1, XuBLYlng.size());
		assertEquals(1, CQTeG48Y.requests.size());
		HttpRequest JQX8i1Tz = CQTeG48Y.requests.get(0);
		assertEquals(HTTP_REQUEST_URL, JQX8i1Tz.getUri().toString());
		assertEquals("POST", JQX8i1Tz.getMethod());
		assertEquals(60, JQX8i1Tz.getCacheTtl());
		return XuBLYlng.iterator().next().toString();
	}

}