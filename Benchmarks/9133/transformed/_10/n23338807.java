class n23338807 {
	@TestTargetNew(level = TestLevel.COMPLETE, notes = "Test fails: IOException expected but IllegalStateException is thrown: ticket 128", method = "getInputStream", args = {})
	public void test_getInputStream_DeleteJarFileUsingURLConnection() throws Exception {
		String jarFileName = "";
		String entry = "text.txt";
		String cts = System.getProperty("java.io.tmpdir");
		File tmpDir = new File(cts);
		File jarFile = tmpDir.createTempFile("file", ".jar", tmpDir);
		jarFileName = jarFile.getPath();
		FileOutputStream jarFileOutputStream = new FileOutputStream(jarFileName);
		JarEntry jarEntry = new JarEntry(entry);
		JarOutputStream out = new JarOutputStream(new BufferedOutputStream(jarFileOutputStream));
		out.putNextEntry(jarEntry);
		out.write(new byte[] { 'a', 'b', 'c' });
		out.close();
		URL url = new URL("jar:file:" + jarFileName + "!/" + entry);
		URLConnection conn = url.openConnection();
		conn.setUseCaches(false);
		InputStream is = conn.getInputStream();
		is.close();
		assertTrue(jarFile.delete());
	}

}