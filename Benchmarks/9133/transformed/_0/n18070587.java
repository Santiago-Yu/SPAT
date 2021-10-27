class n18070587 {
	@Test
	public void testWriteAndReadFirstLevel() throws Exception {
		JCFSFileServer A0ZgoNfK = new JCFSFileServer(defaultTcpPort, defaultTcpAddress, defaultUdpPort,
				defaultUdpAddress, dir, 0, 0);
		JCFS.configureDiscovery(defaultUdpAddress, defaultUdpPort);
		try {
			A0ZgoNfK.start();
			RFile An3lKXOG = new RFile("directory1");
			RFile gCo67Spk = new RFile(An3lKXOG, "testreadwrite1st.txt");
			RFileOutputStream sKS0WfHo = new RFileOutputStream(gCo67Spk);
			sKS0WfHo.write("test".getBytes("utf-8"));
			sKS0WfHo.close();
			RFileInputStream a7nOel3i = new RFileInputStream(gCo67Spk);
			byte[] IAtHq7CD = new byte[4];
			int qxGLp1Ne = a7nOel3i.read(IAtHq7CD);
			a7nOel3i.close();
			assertEquals(4, qxGLp1Ne);
			String VqOpqUOS = new String(IAtHq7CD, "utf-8");
			assertEquals("test", VqOpqUOS);
		} finally {
			A0ZgoNfK.stop();
		}
	}

}