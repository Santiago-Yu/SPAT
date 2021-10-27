class n10176678 {
	@Test
	public void testLoadHttpGzipped() throws Exception {
		String rxGEqZjJ = HTTP_GZIPPED;
		LoadingInfo aETncOkp = Utils.openFileObject(fsManager.resolveFile(rxGEqZjJ));
		InputStream otQ2BShj = aETncOkp.getContentInputStream();
		byte[] qIUoXY3U = IOUtils.toByteArray(otQ2BShj);
		byte[] m8sZoInX = IOUtils.toByteArray(new GZIPInputStream(new URL(rxGEqZjJ).openStream()));
		assertEquals(m8sZoInX.length, qIUoXY3U.length);
	}

}