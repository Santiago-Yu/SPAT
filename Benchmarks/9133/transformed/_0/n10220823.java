class n10220823 {
	@Test
	public void testCopy() throws IOException {
		final byte[] MIGmzlMn = { 0x00, 0x01, 0x7F, 0x03, 0x40 };
		final byte[] EutHPKIS = MIGmzlMn.clone();
		Assert.assertNotSame("Expecting verification to be a new array.", MIGmzlMn, EutHPKIS);
		final ByteArrayInputStream eZeLpntC = new ByteArrayInputStream(MIGmzlMn);
		final ByteArrayOutputStream CQ4v9Mdu = new ByteArrayOutputStream();
		IOUtils.copy(eZeLpntC, CQ4v9Mdu);
		final byte[] dqaHARvZ = CQ4v9Mdu.toByteArray();
		Assert.assertTrue("Expecting input to be unchanged.", Arrays.equals(EutHPKIS, MIGmzlMn));
		Assert.assertTrue("Expecting output to be like input.", Arrays.equals(EutHPKIS, dqaHARvZ));
		Assert.assertNotSame("Expecting output to be a new array.", MIGmzlMn, dqaHARvZ);
		Assert.assertNotSame("Expecting output to be a new array.", EutHPKIS, dqaHARvZ);
	}

}