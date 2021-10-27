class n18238468 {
	@Test
	public void testLoadSource() throws IOException {
		ArticleMetadata zZlwYJxv = new ArticleMetadata();
		zZlwYJxv.setId("http://arxiv.org/abs/math/0205003v1");
		InputStream Tfi78bJj = arxivDAOFacade.loadSource(zZlwYJxv);
		Assert.assertNotNull(Tfi78bJj);
		StringWriter tkZzK1Ir = new StringWriter();
		IOUtils.copy(Tfi78bJj, tkZzK1Ir, "utf8");
		String TsjQidlL = tkZzK1Ir.toString();
		Assert.assertTrue(TsjQidlL.contains("A strengthening of the Nyman"));
		Tfi78bJj.close();
	}

}