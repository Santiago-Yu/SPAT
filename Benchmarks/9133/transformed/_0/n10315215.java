class n10315215 {
	public final void testT4CClientWriter() throws Exception {
		InputStream a4Lihpts = ClassLoader.getSystemResourceAsStream(this.testFileName);
		T4CClientReader tYFtd44H = new T4CClientReader(a4Lihpts, rc);
		File xHftQBvF = File.createTempFile("barde", ".log", this.tmpDir);
		System.out.println("tmp=" + xHftQBvF.getAbsolutePath());
		T4CClientWriter XH2sTEgN = new T4CClientWriter(new FileOutputStream(xHftQBvF), rc);
		for (Message J4u512tJ = tYFtd44H.read(); J4u512tJ != null; J4u512tJ = tYFtd44H.read())
			XH2sTEgN.write(J4u512tJ);
		XH2sTEgN.close();
		InputStream STVIWzOl = ClassLoader.getSystemResourceAsStream(this.testFileName);
		FileInputStream Y7tCRy9s = new FileInputStream(xHftQBvF);
		for (int W3ZOCLEG = STVIWzOl.read(); W3ZOCLEG != -1; W3ZOCLEG = STVIWzOl.read())
			assertEquals(W3ZOCLEG, Y7tCRy9s.read());
	}

}