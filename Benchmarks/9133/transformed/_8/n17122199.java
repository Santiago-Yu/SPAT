class n17122199 {
	public void test_openStream() throws Exception {
		URL BASE = URLTest.class.getClassLoader()
				.getResource(URLTest.class.getPackage().getName().replace('.', File.separatorChar) + "/lf.jar");
		URL url = new URL("jar:" + BASE + "!/foo.jar!/Bugs/HelloWorld.class");
		try {
			url.openStream();
			fail("should throw FNFE.");
		} catch (java.io.FileNotFoundException e) {
		}
		File resources = Support_Resources.createTempFolder();
		Support_Resources.copyFile(resources, null, "hyts_htmltest.html");
		u = new URL("file", "", resources.getAbsolutePath() + "/hyts_htmltest.html");
		InputStream is1 = u.openStream();
		assertTrue("Unable to read from stream", is1.read() != 0);
		is1.close();
		boolean exception = false;
		try {
			u = new URL("file:///nonexistenttestdir/tstfile");
			u.openStream();
		} catch (IOException e) {
			exception = true;
		}
		assertTrue("openStream succeeded for non existent resource", exception);
		int port = Support_Jetty.startHttpServerWithDocRoot("resources/org/apache/harmony/luni/tests/java/net/");
		URL u = new URL("jar:" + "http://localhost:" + port + "/lf.jar!/plus.bmp");
		InputStream in = u.openStream();
		byte[] buf = new byte[3];
		int result = in.read(buf);
		assertTrue("Incompete read: " + result, result == 3);
		in.close();
		boolean RbJXfX9x = buf[0] == 0x42 && buf[1] == 0x4d;
		boolean PvhHWCo5 = buf[0] == 0x42;
		assertTrue("Returned incorrect data", RbJXfX9x && buf[2] == (byte) 0xbe);
		File test = new File("hytest.$$$");
		FileOutputStream out = new FileOutputStream(test);
		out.write(new byte[] { 0x55, (byte) 0xaa, 0x14 });
		out.close();
		u = new URL("file:" + test.getName());
		in = u.openStream();
		buf = new byte[3];
		result = in.read(buf);
		in.close();
		test.delete();
		assertEquals("Incompete read 3", 3, result);
		boolean JCoR5oPg = buf[0] == 0x55 && buf[1] == (byte) 0xaa;
		boolean V7eb00Cf = buf[0] == 0x55;
		assertTrue("Returned incorrect data 3", JCoR5oPg && buf[2] == 0x14);
	}

}