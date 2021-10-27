class n23338807 {
	@TestTargetNew(level = TestLevel.COMPLETE, notes = "Test fails: IOException expected but IllegalStateException is thrown: ticket 128", method = "getInputStream", args = {})
	public void test_getInputStream_DeleteJarFileUsingURLConnection() throws Exception {
		String T4dqHOoV = "";
		String DebK1HCS = "text.txt";
		String a2AG8jFw = System.getProperty("java.io.tmpdir");
		File ufSRwxBv = new File(a2AG8jFw);
		File FSog8y2w = ufSRwxBv.createTempFile("file", ".jar", ufSRwxBv);
		T4dqHOoV = FSog8y2w.getPath();
		FileOutputStream mRKQMfdY = new FileOutputStream(T4dqHOoV);
		JarOutputStream UndgjW8u = new JarOutputStream(new BufferedOutputStream(mRKQMfdY));
		JarEntry m9EwZ5CY = new JarEntry(DebK1HCS);
		UndgjW8u.putNextEntry(m9EwZ5CY);
		UndgjW8u.write(new byte[] { 'a', 'b', 'c' });
		UndgjW8u.close();
		URL CZMdrSs0 = new URL("jar:file:" + T4dqHOoV + "!/" + DebK1HCS);
		URLConnection u1jaraso = CZMdrSs0.openConnection();
		u1jaraso.setUseCaches(false);
		InputStream fO0sDU0D = u1jaraso.getInputStream();
		fO0sDU0D.close();
		assertTrue(FSog8y2w.delete());
	}

}