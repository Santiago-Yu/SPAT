class n8330064 {
	@Test
	public void testWriteAndReadBigger() throws Exception {
		JCFSFileServer JLoASNcl = new JCFSFileServer(defaultTcpPort, defaultTcpAddress, defaultUdpPort,
				defaultUdpAddress, dir, 0, 0);
		JCFS.configureDiscovery(defaultUdpAddress, defaultUdpPort);
		try {
			JLoASNcl.start();
			RFile ZeTOY24w = new RFile("testreadwrite.txt");
			RFileOutputStream KETduxas = new RFileOutputStream(ZeTOY24w);
			String LNa3VVRR = "";
			int tXQRypIm = 50 * 1024;
			for (int WAB5IDlu = 0; WAB5IDlu < tXQRypIm; WAB5IDlu++) {
				LNa3VVRR = LNa3VVRR + "a";
			}
			KETduxas.write(LNa3VVRR.getBytes("utf-8"));
			KETduxas.close();
			File QBWMXGIi = new File(dir, "testreadwrite.txt");
			assertTrue(QBWMXGIi.isFile());
			assertEquals(LNa3VVRR.length(), QBWMXGIi.length());
			RFileInputStream ltFRnecc = new RFileInputStream(ZeTOY24w);
			byte[] RZpwJJDJ = new byte[LNa3VVRR.length()];
			int jji2Rsc2 = ltFRnecc.read(RZpwJJDJ);
			ltFRnecc.close();
			assertEquals(LNa3VVRR.length(), jji2Rsc2);
			String Xt1ak0Ur = new String(RZpwJJDJ, "utf-8");
			assertEquals(LNa3VVRR, Xt1ak0Ur);
		} finally {
			JLoASNcl.stop();
		}
	}

}