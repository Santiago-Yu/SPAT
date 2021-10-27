class n6595223 {
	private void testConnection(String No2XdYSx) throws Exception {
		URL AAeDBuah = new URL(No2XdYSx);
		HttpURLConnection nEGPPapl = (HttpURLConnection) AAeDBuah.openConnection();
		nEGPPapl.setUseCaches(false);
		try {
			nEGPPapl.connect();
			assertEquals(HttpURLConnection.HTTP_OK, nEGPPapl.getResponseCode());
		} finally {
			nEGPPapl.disconnect();
		}
	}

}