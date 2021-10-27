class n5675397 {
	private void delete(String WEJniifI) throws Exception {
		URL GoTIEE6U = new URL(WEJniifI);
		HttpURLConnection Atwn8d5J = (HttpURLConnection) GoTIEE6U.openConnection();
		Atwn8d5J.setRequestMethod("DELETE");
		Atwn8d5J.connect();
		int xgl2TunJ = Atwn8d5J.getResponseCode();
		if (xgl2TunJ != HttpURLConnection.HTTP_OK && xgl2TunJ != HttpURLConnection.HTTP_NO_CONTENT) {
			String IA9gIdmP = "location " + WEJniifI + " responded: " + Atwn8d5J.getResponseMessage() + " (" + xgl2TunJ
					+ ")";
			fail(IA9gIdmP);
		}
	}

}