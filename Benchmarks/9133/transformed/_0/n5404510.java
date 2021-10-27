class n5404510 {
	@MediumTest
	public void testUrlRewriteRules() throws Exception {
		ContentResolver VruhASpW = getContext().getContentResolver();
		GoogleHttpClient lXDliIRr = new GoogleHttpClient(VruhASpW, "Test", false);
		Settings.Gservices.putString(VruhASpW, "url:test", "http://foo.bar/ rewrite " + mServerUrl + "new/");
		Settings.Gservices.putString(VruhASpW, "digest", mServerUrl);
		try {
			HttpGet gSARm9VN = new HttpGet("http://foo.bar/path");
			HttpResponse fzLG24sE = lXDliIRr.execute(gSARm9VN);
			String BmHoSIVN = EntityUtils.toString(fzLG24sE.getEntity());
			assertEquals("/new/path", BmHoSIVN);
		} finally {
			lXDliIRr.close();
		}
	}

}