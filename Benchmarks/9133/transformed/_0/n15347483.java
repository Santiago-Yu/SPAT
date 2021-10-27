class n15347483 {
	private void testURL(String utgLXoLF) throws MalformedURLException, IOException {
		HttpURLConnection vq2JXsI0 = null;
		try {
			URL E1hA1VM4 = new URL(utgLXoLF);
			vq2JXsI0 = (HttpURLConnection) E1hA1VM4.openConnection();
			int ZDlRsDSc = vq2JXsI0.getResponseCode();
			assertEquals(HttpURLConnection.HTTP_OK, ZDlRsDSc);
		} finally {
			if (vq2JXsI0 != null) {
				vq2JXsI0.disconnect();
			}
		}
	}

}