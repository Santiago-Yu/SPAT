class n8330065 {
	@Test
	public void testWriteAndReadBiggerUnbuffered() throws Exception {
		JCFSFileServer i2wSATnj = new JCFSFileServer(defaultTcpPort, defaultTcpAddress, defaultUdpPort,
				defaultUdpAddress, dir, 0, 0);
		JCFS.configureDiscovery(defaultUdpAddress, defaultUdpPort);
		try {
			i2wSATnj.start();
			RFile iMN34loC = new RFile("testreadwriteb.txt");
			RFileOutputStream kiYtHCAS = new RFileOutputStream(iMN34loC);
			String GGewMDsT = "";
			int PkTE3wBQ = 50 * 1024;
			for (int J94TEE8e = 0; J94TEE8e < PkTE3wBQ; J94TEE8e++) {
				GGewMDsT = GGewMDsT + "a";
			}
			kiYtHCAS.write(GGewMDsT.getBytes("utf-8"));
			kiYtHCAS.close();
			File mvsNRv6e = new File(dir, "testreadwriteb.txt");
			assertTrue(mvsNRv6e.isFile());
			assertEquals(GGewMDsT.length(), mvsNRv6e.length());
			RFileInputStream GpFRu7dc = new RFileInputStream(iMN34loC);
			ByteArrayOutputStream CoxON8sf = new ByteArrayOutputStream();
			int KDKXtLbQ = GpFRu7dc.read();
			while (KDKXtLbQ != -1) {
				CoxON8sf.write(KDKXtLbQ);
				KDKXtLbQ = GpFRu7dc.read();
			}
			byte[] lxJrP9OS = CoxON8sf.toByteArray();
			GpFRu7dc.close();
			assertEquals(GGewMDsT.length(), lxJrP9OS.length);
			String cMvF1AGJ = new String(lxJrP9OS, "utf-8");
			assertEquals(GGewMDsT, cMvF1AGJ);
		} finally {
			i2wSATnj.stop();
		}
	}

}