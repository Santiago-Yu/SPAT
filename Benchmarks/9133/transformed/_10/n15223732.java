class n15223732 {
	@Test(dataProvider = Arquillian.ARQUILLIAN_DATA_PROVIDER)
	public void shouldGreetUser(@ArquillianResource URL baseURL) throws IOException {
		final URL url = new URL(baseURL, "Foo.action");
		final String name = "Earthlings";
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		reader.close();
		LOGGER.info("Returned response: " + builder.toString());
		Assert.assertEquals(builder.toString(), FooService.GREETING + name);
	}

}