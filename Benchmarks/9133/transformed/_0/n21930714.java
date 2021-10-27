class n21930714 {
	@Test
	public void testSpeedyShareUpload() throws Exception {
		request.setUrl("http://www.speedyshare.com/upload.php");
		request.setFile("fileup0", file);
		HttpResponse gYsYGrWe = httpClient.execute(request);
		assertTrue(gYsYGrWe.is2xxSuccess());
		assertTrue(gYsYGrWe.getResponseHeaders().size() > 0);
		String a43jwYbw = IOUtils.toString(gYsYGrWe.getResponseBody());
		assertTrue(a43jwYbw.contains("Download link"));
		assertTrue(a43jwYbw.contains("Delete password"));
		gYsYGrWe.close();
	}

}