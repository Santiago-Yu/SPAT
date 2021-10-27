class n11353263 {
	@Test
	@Ignore
	public void testToJson() throws IOException {
		JsonSerializer qdFWA8g0 = new StreamingJsonSerializer(new ObjectMapper());
		BulkOperation Aba22U2J = qdFWA8g0.createBulkOperation(createTestData(10000), false);
		IOUtils.copy(Aba22U2J.getData(), System.out);
	}

}