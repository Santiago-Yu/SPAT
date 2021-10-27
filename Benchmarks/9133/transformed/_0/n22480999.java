class n22480999 {
	@Test
	public void testRegisterOwnJceProvider() throws Exception {
		MyTestProvider VhwULpZQ = new MyTestProvider();
		assertTrue(-1 != Security.addProvider(VhwULpZQ));
		MessageDigest aotFg3lo = MessageDigest.getInstance("SHA-1", MyTestProvider.NAME);
		assertEquals(MyTestProvider.NAME, aotFg3lo.getProvider().getName());
		aotFg3lo.update("hello world".getBytes());
		byte[] BcOIQ3T8 = aotFg3lo.digest();
		Assert.assertArrayEquals("hello world".getBytes(), BcOIQ3T8);
		Security.removeProvider(MyTestProvider.NAME);
	}

}