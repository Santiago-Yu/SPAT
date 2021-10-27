class n22303544 {
	@Test
	public void testWriteAndRead() throws Exception {
		JCFSFileServer sFHQoWOa = new JCFSFileServer(defaultTcpPort, defaultTcpAddress, defaultUdpPort,
				defaultUdpAddress, dir, 0, 0);
		JCFS.configureDiscovery(defaultUdpAddress, defaultUdpPort);
		try {
			sFHQoWOa.start();
			RFile Ja7QJ5SZ = new RFile("testreadwrite.txt");
			RFileOutputStream eWqsuK1N = new RFileOutputStream(Ja7QJ5SZ);
			eWqsuK1N.write("test".getBytes("utf-8"));
			eWqsuK1N.close();
			RFileInputStream uL0Z7IwQ = new RFileInputStream(Ja7QJ5SZ);
			byte[] Sam2aVPT = new byte[4];
			int ul1M2HaH = uL0Z7IwQ.read(Sam2aVPT);
			uL0Z7IwQ.close();
			assertEquals(4, ul1M2HaH);
			String CHRFc2wC = new String(Sam2aVPT, "utf-8");
			assertEquals("test", CHRFc2wC);
		} finally {
			sFHQoWOa.stop();
		}
	}

}