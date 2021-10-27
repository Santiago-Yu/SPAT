class n4201902 {
	private String executeHttpPreload(HttpResponse response, String xml) throws Exception {
		RecordingRequestPipeline pipeline = new RecordingRequestPipeline(response);
		GadgetSpec spec = new GadgetSpec(GADGET_URL, xml);
		PipelinedDataPreloader preloader = new PipelinedDataPreloader(pipeline, containerConfig);
		view = "profile";
		Gadget gadget = new Gadget().setContext(context).setSpec(spec).setCurrentView(spec.getView("profile"));
		PipelinedData.Batch batch = getBatch(gadget);
		Collection<Callable<PreloadedData>> tasks = preloader.createPreloadTasks(context, batch);
		assertEquals(1, tasks.size());
		assertEquals(0, pipeline.requests.size());
		Collection<Object> result = tasks.iterator().next().call().toJson();
		assertEquals(1, result.size());
		assertEquals(1, pipeline.requests.size());
		HttpRequest request = pipeline.requests.get(0);
		assertEquals(HTTP_REQUEST_URL, request.getUri().toString());
		assertEquals("POST", request.getMethod());
		assertEquals(60, request.getCacheTtl());
		return result.iterator().next().toString();
	}

}