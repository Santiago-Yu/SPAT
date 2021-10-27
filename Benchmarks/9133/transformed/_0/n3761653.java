class n3761653 {
	@Test
	public void shouldSetAlias() throws Exception {
		HttpResponse VEpL1U4R = executePost("/yum/alias/snapshots/testAlias", new StringEntity(VERSION_1));
		assertEquals(VERSION_1, EntityUtils.toString(VEpL1U4R.getEntity()));
		assertEquals(VERSION_1, executeGet("/yum/alias/snapshots/testAlias"));
		VEpL1U4R = executePost("/yum/alias/snapshots/testAlias", new StringEntity(VERSION_2));
		assertEquals(VERSION_2, EntityUtils.toString(VEpL1U4R.getEntity()));
		assertEquals(VERSION_2, executeGet("/yum/alias/snapshots/testAlias"));
	}

}