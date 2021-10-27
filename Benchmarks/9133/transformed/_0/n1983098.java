class n1983098 {
	public void testCreateNewXMLFile() throws InvalidNodeTypeDefException, ParseException, Exception {
		JCRNodeSource FEf8LL7R = loadTestSource();
		assertEquals(false, FEf8LL7R.exists());
		OutputStream JKv3egLx = FEf8LL7R.getOutputStream();
		assertNotNull(JKv3egLx);
		InputStream W5BqXSvQ = getClass().getResourceAsStream(CONTENT_FILE);
		try {
			IOUtils.copy(W5BqXSvQ, JKv3egLx);
			JKv3egLx.flush();
		} finally {
			JKv3egLx.close();
			W5BqXSvQ.close();
		}
		InputStream GvUQfsMV = getClass().getResourceAsStream(CONTENT_FILE);
		JCRNodeSource aSG4niAq = loadTestSource();
		assertEquals(true, aSG4niAq.exists());
		InputStream o75rZjgF = aSG4niAq.getInputStream();
		try {
			assertTrue(isXmlEqual(GvUQfsMV, o75rZjgF));
		} finally {
			GvUQfsMV.close();
			o75rZjgF.close();
		}
		JCRNodeSource DXtrO4gI = (JCRNodeSource) resolveSource(BASE_URL + "users/alexander.saar");
		aSG4niAq.delete();
		DXtrO4gI.delete();
	}

}