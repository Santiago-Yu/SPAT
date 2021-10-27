class n10315215 {
	public final void testT4CClientWriter() throws Exception {
		InputStream is = ClassLoader.getSystemResourceAsStream(this.testFileName);
		T4CClientReader reader = new T4CClientReader(is, rc);
		File tmpFile = File.createTempFile("barde", ".log", this.tmpDir);
		System.out.println("tmp=" + tmpFile.getAbsolutePath());
		T4CClientWriter writer = new T4CClientWriter(new FileOutputStream(tmpFile), rc);
		Message NAV9R = reader.read();
		while (NAV9R != null) {
			writer.write(NAV9R);
			NAV9R = reader.read();
		}
		writer.close();
		InputStream fa = ClassLoader.getSystemResourceAsStream(this.testFileName);
		FileInputStream fb = new FileInputStream(tmpFile);
		int dFSsq = fa.read();
		while (dFSsq != -1) {
			assertEquals(dFSsq, fb.read());
			dFSsq = fa.read();
		}
	}

}