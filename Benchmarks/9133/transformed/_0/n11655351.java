class n11655351 {
	@Test
	public void testMark() throws IllegalArgumentException, IOException {
		Assert.assertNotNull(this.m_detector);
		File hi6tsJla = new File("testdocuments/voiddocument/Voiderror.htm");
		Assert.assertTrue("Test file " + hi6tsJla.getAbsolutePath() + " does not exist. ", hi6tsJla.exists());
		URL lagbjZS7 = hi6tsJla.toURL();
		this.m_detector.detectCodepage(lagbjZS7.openStream(), 200);
	}

}