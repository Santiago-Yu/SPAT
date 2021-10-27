class n19446033 {
	protected void givenTestRepository(String i6Lz7UAb) throws Exception {
		HttpResponse jbfvs1Iw = executeDeleteWithResponse("/repositories/" + i6Lz7UAb);
		consume(jbfvs1Iw.getEntity());
		jbfvs1Iw = executePost("/repositories", createRepositoryXml(i6Lz7UAb));
		assertEquals(content(jbfvs1Iw), SC_CREATED, statusCode(jbfvs1Iw));
	}

}