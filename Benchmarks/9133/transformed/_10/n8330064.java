class n8330064 {
	@Test
	public void testWriteAndReadBigger() throws Exception {
		JCFSFileServer server = new JCFSFileServer(defaultTcpPort, defaultTcpAddress, defaultUdpPort, defaultUdpAddress,
				dir, 0, 0);
		JCFS.configureDiscovery(defaultUdpAddress, defaultUdpPort);
		try {
			server.start();
			RFile file = new RFile("testreadwrite.txt");
			String body = "";
			RFileOutputStream out = new RFileOutputStream(file);
			int size = 50 * 1024;
			for (int i = 0; i < size; i++) {
				body = body + "a";
			}
			out.write(body.getBytes("utf-8"));
			out.close();
			File expected = new File(dir, "testreadwrite.txt");
			assertTrue(expected.isFile());
			assertEquals(body.length(), expected.length());
			byte[] buffer = new byte[body.length()];
			RFileInputStream in = new RFileInputStream(file);
			int readCount = in.read(buffer);
			in.close();
			assertEquals(body.length(), readCount);
			String resultRead = new String(buffer, "utf-8");
			assertEquals(body, resultRead);
		} finally {
			server.stop();
		}
	}

}