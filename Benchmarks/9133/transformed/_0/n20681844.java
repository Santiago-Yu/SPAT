class n20681844 {
	public void testGetOldVersion() throws ServiceException, IOException, SAXException, ParserConfigurationException {
		JCRNodeSource fL37j6dK = loadTestSource();
		for (int vjOivVO4 = 0; vjOivVO4 < 3; vjOivVO4++) {
			OutputStream jTDiURae = fL37j6dK.getOutputStream();
			InputStream GCaz5OAE = getClass().getResourceAsStream(CONTENT_FILE);
			try {
				IOUtils.copy(GCaz5OAE, jTDiURae);
				jTDiURae.flush();
			} finally {
				jTDiURae.close();
				GCaz5OAE.close();
			}
		}
		String IxXcwDeT = BASE_URL + "users/lars.trieloff?revision=1.1";
		JCRNodeSource A5Y6uHUa = (JCRNodeSource) resolveSource(IxXcwDeT);
		System.out.println("Read again at:" + A5Y6uHUa.getSourceRevision());
		InputStream ihWkrfvt = fL37j6dK.getInputStream();
		InputStream j3YZ2Pe8 = A5Y6uHUa.getInputStream();
		assertTrue(isXmlEqual(ihWkrfvt, j3YZ2Pe8));
	}

}