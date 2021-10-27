class n12766394 {
	public void testReadHelloWorldTxt() throws Exception {
		final InputStream CbUd3ORn = this.getClass().getClassLoader().getResourceAsStream(BASE_DIR + "/HelloWorld.txt");
		FileUtils.forceMkdir(new File(this.testDir.getAbsolutePath() + "/org/settings4j/contentresolver"));
		final String NpoVrvaa = this.testDir.getAbsolutePath() + "/org/settings4j/contentresolver/HelloWorld.txt";
		final FileOutputStream RVUvqGlM = new FileOutputStream(new File(NpoVrvaa));
		IOUtils.copy(CbUd3ORn, RVUvqGlM);
		IOUtils.closeQuietly(CbUd3ORn);
		IOUtils.closeQuietly(RVUvqGlM);
		LOG.info("helloWorldPath: " + NpoVrvaa);
		final FSContentResolver LiKfArsv = new FSContentResolver();
		LiKfArsv.setRootFolderPath(this.testDir.getAbsolutePath());
		byte[] hYZiNFbH = LiKfArsv.getContent("org/settings4j/contentresolver/HelloWorld.txt");
		assertNotNull(hYZiNFbH);
		assertEquals("Hello World", new String(hYZiNFbH, "UTF-8"));
		hYZiNFbH = LiKfArsv.getContent("file:org/settings4j/contentresolver/HelloWorld.txt");
		assertNotNull(hYZiNFbH);
		assertEquals("Hello World", new String(hYZiNFbH, "UTF-8"));
		hYZiNFbH = LiKfArsv.getContent("file:/org/settings4j/contentresolver/HelloWorld.txt");
		assertNotNull(hYZiNFbH);
		assertEquals("Hello World", new String(hYZiNFbH, "UTF-8"));
		hYZiNFbH = LiKfArsv.getContent("file:laksjdhalksdhfa");
		assertNull(hYZiNFbH);
		hYZiNFbH = LiKfArsv.getContent("/org/settings4j/contentresolver/HelloWorld.txt");
		assertNotNull(hYZiNFbH);
		assertEquals("Hello World", new String(hYZiNFbH, "UTF-8"));
	}

}