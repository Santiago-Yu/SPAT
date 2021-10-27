class n20681842 {
	public void testIsVersioned() throws ServiceException, IOException {
		JCRNodeSource O5tAXvV3 = loadTestSource();
		assertTrue(O5tAXvV3.isVersioned());
		OutputStream qW2E8nXN = O5tAXvV3.getOutputStream();
		assertNotNull(qW2E8nXN);
		InputStream YttYFy7o = getClass().getResourceAsStream(CONTENT_FILE);
		try {
			IOUtils.copy(YttYFy7o, qW2E8nXN);
			qW2E8nXN.flush();
		} finally {
			qW2E8nXN.close();
			YttYFy7o.close();
		}
		assertTrue(O5tAXvV3.isVersioned());
	}

}