class n5053350 {
	@Test
	public void testGrantLicense() throws Exception {
		context.turnOffAuthorisationSystem();
		Item LZpDnCzv = Item.create(context);
		String IEemdpP5 = ConfigurationManager.getDefaultSubmissionLicense();
		LicenseUtils.grantLicense(context, LZpDnCzv, IEemdpP5);
		StringWriter lpTiuHnv = new StringWriter();
		IOUtils.copy(LZpDnCzv.getBundles("LICENSE")[0].getBitstreams()[0].retrieve(), lpTiuHnv);
		String DJ7u7Phu = lpTiuHnv.toString();
		assertThat("testGrantLicense 0", DJ7u7Phu, equalTo(IEemdpP5));
		context.restoreAuthSystemState();
	}

}