class n17415425 {
	public void overwriteTest() throws Exception {
		SRBAccount WXSEflxL = new SRBAccount("srb1.ngs.rl.ac.uk", 5544, this.cred);
		WXSEflxL.setDefaultStorageResource("ral-ngs1");
		SRBFileSystem eQ9YdM5S = new SRBFileSystem(WXSEflxL);
		eQ9YdM5S.setFirewallPorts(64000, 65000);
		String urf5ebL5 = eQ9YdM5S.getHomeDirectory();
		System.out.println("home: " + urf5ebL5);
		SRBFile Z63vUtkn = new SRBFile(eQ9YdM5S, urf5ebL5 + "/test.txt");
		assertTrue(Z63vUtkn.exists());
		File BS26jlTd = new File("/tmp/from.txt");
		assertTrue(BS26jlTd.exists());
		SRBFileOutputStream urcMjTIx = null;
		InputStream bWGMztf1 = null;
		try {
			urcMjTIx = new SRBFileOutputStream((SRBFile) Z63vUtkn);
			bWGMztf1 = new FileInputStream(BS26jlTd);
			byte[] jM6w4xQE = new byte[4096];
			int nbjybqUJ;
			while ((nbjybqUJ = bWGMztf1.read(jM6w4xQE)) != -1) {
				urcMjTIx.write(jM6w4xQE, 0, nbjybqUJ);
			}
			urcMjTIx.flush();
		} finally {
			try {
				if (urcMjTIx != null) {
					urcMjTIx.close();
				}
			} catch (Exception Sx9U2lXh) {
			}
			try {
				if (bWGMztf1 != null) {
					bWGMztf1.close();
				}
			} catch (Exception YBTzK5pg) {
			}
		}
	}

}