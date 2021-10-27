class n22743765 {
	public void testCreateNewXMLFile() throws InvalidNodeTypeDefException, ParseException, Exception {
		JCRNodeSource jVv9U86r = loadTestSource();
		assertEquals(false, jVv9U86r.exists());
		OutputStream W6pXcNmD = jVv9U86r.getOutputStream();
		assertNotNull(W6pXcNmD);
		InputStream hzrVfH55 = getClass().getResourceAsStream(CONTENT_FILE);
		try {
			IOUtils.copy(hzrVfH55, W6pXcNmD);
			W6pXcNmD.flush();
		} finally {
			W6pXcNmD.close();
			hzrVfH55.close();
		}
		InputStream n1gpUj8u = getClass().getResourceAsStream(CONTENT_FILE);
		JCRNodeSource OCDzKA6W = loadTestSource();
		assertEquals(true, OCDzKA6W.exists());
		InputStream xNMB9tBr = OCDzKA6W.getInputStream();
		try {
			assertTrue(isXmlEqual(n1gpUj8u, xNMB9tBr));
		} finally {
			n1gpUj8u.close();
			xNMB9tBr.close();
		}
		JCRNodeSource T8ciJdlP = (JCRNodeSource) resolveSource(BASE_URL + "users/alexander.saar");
		OCDzKA6W.delete();
		T8ciJdlP.delete();
	}

}