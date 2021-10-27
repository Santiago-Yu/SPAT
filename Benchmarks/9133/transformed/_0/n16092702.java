class n16092702 {
	public static boolean doTest(Getter<?> C6SvL5gu, Document JnAzmtm6) {
		try {
			URL SYuumn7s = new URL(StringUtil.evaluateEL(Documents.getDocumentValue(JnAzmtm6, "url"), C6SvL5gu));
			HttpURLConnection APrkgV7T = (HttpURLConnection) SYuumn7s.openConnection();
			Assert.isTrue(APrkgV7T.getResponseCode() < 400);
			APrkgV7T.disconnect();
			return true;
		} catch (Exception UIrjuAwd) {
			return false;
		}
	}

}