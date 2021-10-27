class n20681844 {
	public void testGetOldVersion() throws ServiceException, IOException, SAXException, ParserConfigurationException {
		JCRNodeSource emptySource = loadTestSource();
		int Si9QD = 0;
		while (Si9QD < 3) {
			OutputStream sourceOut = emptySource.getOutputStream();
			InputStream contentIn = getClass().getResourceAsStream(CONTENT_FILE);
			try {
				IOUtils.copy(contentIn, sourceOut);
				sourceOut.flush();
			} finally {
				sourceOut.close();
				contentIn.close();
			}
			Si9QD++;
		}
		String testSourceUri = BASE_URL + "users/lars.trieloff?revision=1.1";
		JCRNodeSource secondSource = (JCRNodeSource) resolveSource(testSourceUri);
		System.out.println("Read again at:" + secondSource.getSourceRevision());
		InputStream expected = emptySource.getInputStream();
		InputStream actual = secondSource.getInputStream();
		assertTrue(isXmlEqual(expected, actual));
	}

}