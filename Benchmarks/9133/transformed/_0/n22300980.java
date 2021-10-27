class n22300980 {
	@Test
	public void testTransactWriteAndRead() throws Exception {
		JCFSFileServer RGTc8rtU = new JCFSFileServer(defaultTcpPort, defaultTcpAddress, defaultUdpPort,
				defaultUdpAddress, dir, 0, 0);
		JCFS.configureDiscovery(defaultUdpAddress, defaultUdpPort);
		try {
			RGTc8rtU.start();
			RFile kZ6rg2mP = new RFile("testreadwritetrans.txt");
			RFileOutputStream XtTPtcn1 = new RFileOutputStream(kZ6rg2mP, WriteMode.TRANSACTED, false, 1);
			XtTPtcn1.write("test".getBytes("utf-8"));
			XtTPtcn1.close();
			RFileInputStream gCfYTw7L = new RFileInputStream(kZ6rg2mP);
			byte[] L61Q3Has = new byte[4];
			int wffCo6U6 = gCfYTw7L.read(L61Q3Has);
			gCfYTw7L.close();
			assertEquals(4, wffCo6U6);
			String rc59D84i = new String(L61Q3Has, "utf-8");
			assertEquals("test", rc59D84i);
		} finally {
			RGTc8rtU.stop();
		}
	}

}