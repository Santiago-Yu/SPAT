class n20681845 {
	public void testCreateNewXMLFile() throws InvalidNodeTypeDefException, ParseException, Exception {
		JCRNodeSource o7NvNWz8 = loadTestSource();
		assertEquals(false, o7NvNWz8.exists());
		OutputStream AYo3OU9s = o7NvNWz8.getOutputStream();
		assertNotNull(AYo3OU9s);
		InputStream lXILXsdW = getClass().getResourceAsStream(CONTENT_FILE);
		try {
			IOUtils.copy(lXILXsdW, AYo3OU9s);
			AYo3OU9s.flush();
		} finally {
			AYo3OU9s.close();
			lXILXsdW.close();
		}
		InputStream vZNMkBba = getClass().getResourceAsStream(CONTENT2_FILE);
		AYo3OU9s = o7NvNWz8.getOutputStream();
		try {
			IOUtils.copy(vZNMkBba, AYo3OU9s);
			AYo3OU9s.flush();
		} finally {
			AYo3OU9s.close();
			vZNMkBba.close();
		}
		InputStream PsRaHLVc = getClass().getResourceAsStream(CONTENT2_FILE);
		JCRNodeSource gEqsmspI = loadTestSource();
		assertEquals(true, gEqsmspI.exists());
		InputStream uRXRlzSL = gEqsmspI.getInputStream();
		try {
			assertTrue(isXmlEqual(PsRaHLVc, uRXRlzSL));
		} finally {
			PsRaHLVc.close();
			uRXRlzSL.close();
		}
		JCRNodeSource rWHDpEmp = (JCRNodeSource) resolveSource(BASE_URL + "users/alexander.saar");
		gEqsmspI.delete();
		rWHDpEmp.delete();
	}

}