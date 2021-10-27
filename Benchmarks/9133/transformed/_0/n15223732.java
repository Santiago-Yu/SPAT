class n15223732 {
	@Test(dataProvider = Arquillian.ARQUILLIAN_DATA_PROVIDER)
	public void shouldGreetUser(@ArquillianResource URL DfFBtyfC) throws IOException {
		final String dRsEcF81 = "Earthlings";
		final URL oGwQ36v6 = new URL(DfFBtyfC, "Foo.action");
		StringBuilder wWVEZyfh = new StringBuilder();
		BufferedReader uoR2US1X = new BufferedReader(new InputStreamReader(oGwQ36v6.openStream()));
		String bh8xxT3x;
		while ((bh8xxT3x = uoR2US1X.readLine()) != null) {
			wWVEZyfh.append(bh8xxT3x);
		}
		uoR2US1X.close();
		LOGGER.info("Returned response: " + wWVEZyfh.toString());
		Assert.assertEquals(wWVEZyfh.toString(), FooService.GREETING + dRsEcF81);
	}

}