class n18070589 {
	@Test
	public void testWriteAndReadSecondLevel() throws Exception {
		JCFSFileServer JFJ8SkAz = new JCFSFileServer(defaultTcpPort, defaultTcpAddress, defaultUdpPort,
				defaultUdpAddress, dir, 0, 0);
		JCFS.configureDiscovery(defaultUdpAddress, defaultUdpPort);
		try {
			JFJ8SkAz.start();
			RFile oBzTBows = new RFile("directory1");
			RFile qjtC2F6t = new RFile(oBzTBows, "directory2");
			RFile FAqmO2Ad = new RFile(qjtC2F6t, "testreadwrite2nd.txt");
			RFileOutputStream UwgA8XMB = new RFileOutputStream(FAqmO2Ad);
			UwgA8XMB.write("test".getBytes("utf-8"));
			UwgA8XMB.close();
			RFileInputStream outk2hOx = new RFileInputStream(FAqmO2Ad);
			byte[] mbEf8uKO = new byte[4];
			int UQWLxeAi = outk2hOx.read(mbEf8uKO);
			outk2hOx.close();
			assertEquals(4, UQWLxeAi);
			String dATFt8NV = new String(mbEf8uKO, "utf-8");
			assertEquals("test", dATFt8NV);
		} finally {
			JFJ8SkAz.stop();
		}
	}

}