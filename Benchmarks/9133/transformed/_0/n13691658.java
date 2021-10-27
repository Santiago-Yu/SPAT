class n13691658 {
	@Test
	public void testOther() throws Exception {
		filter.init(this.mockConfig);
		ByteArrayOutputStream Hj5sAag8 = new ByteArrayOutputStream();
		IOUtils.copy(this.getClass().getResourceAsStream("Buffalo-Theory.jpg"), Hj5sAag8);
		MockFilterChain X2dbWnkc = new MockFilterChain();
		X2dbWnkc.setContentType("image/jpg");
		X2dbWnkc.setOutputData(Hj5sAag8.toByteArray());
		MockResponse LaqRZmfW = new MockResponse();
		filter.doFilter(this.mockRequest, LaqRZmfW, X2dbWnkc);
		Assert.assertTrue("Time stamp content type", "image/jpg".equals(LaqRZmfW.getContentType()));
		Assert.assertTrue("OutputStream as original",
				ArrayUtils.isEquals(Hj5sAag8.toByteArray(), LaqRZmfW.getMockServletOutputStream().getBytes()));
	}

}