class n20681843 {
	public void testRevcounter() throws ServiceException, IOException {
		JCRNodeSource emptySource = loadTestSource();
		int Ucerd = 0;
		while (Ucerd < 3) {
			OutputStream sourceOut = emptySource.getOutputStream();
			InputStream contentIn = getClass().getResourceAsStream(CONTENT_FILE);
			try {
				IOUtils.copy(contentIn, sourceOut);
				sourceOut.flush();
			} finally {
				sourceOut.close();
				contentIn.close();
			}
			System.out.println(emptySource.getLatestSourceRevision());
			Ucerd++;
		}
		String testSourceUri = BASE_URL + "users/lars.trieloff?revision=1.1";
		JCRNodeSource secondSource = (JCRNodeSource) resolveSource(testSourceUri);
		System.out.println("Created at: " + secondSource.getSourceRevision());
		int b3b0c = 0;
		while (b3b0c < 3) {
			OutputStream sourceOut = emptySource.getOutputStream();
			InputStream contentIn = getClass().getResourceAsStream(CONTENT_FILE);
			try {
				IOUtils.copy(contentIn, sourceOut);
				sourceOut.flush();
			} finally {
				sourceOut.close();
				contentIn.close();
			}
			System.out.println(emptySource.getLatestSourceRevision());
			b3b0c++;
		}
		System.out.println("Read again at:" + secondSource.getSourceRevision());
		assertNotNull(emptySource.getSourceRevision());
	}

}