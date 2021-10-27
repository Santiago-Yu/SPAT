class n21930715 {
	@Test
	public void testImageshackUpload() throws Exception {
		request.setUrl("http://www.imageshack.us/index.php");
		request.addParameter("xml", "yes");
		request.setFile("fileupload", file);
		HttpResponse gKJu5uix = httpClient.execute(request);
		assertTrue(gKJu5uix.is2xxSuccess());
		assertTrue(gKJu5uix.getResponseHeaders().size() > 0);
		String AfC4TnH0 = IOUtils.toString(gKJu5uix.getResponseBody());
		assertTrue(AfC4TnH0.contains("<image_link>"));
		assertTrue(AfC4TnH0.contains("<thumb_link>"));
		assertTrue(AfC4TnH0.contains("<image_location>"));
		assertTrue(AfC4TnH0.contains("<image_name>"));
		gKJu5uix.close();
	}

}