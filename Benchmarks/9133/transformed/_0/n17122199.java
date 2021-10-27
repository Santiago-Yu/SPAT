class n17122199 {
	public void test_openStream() throws Exception {
		URL tWUAeEUN = URLTest.class.getClassLoader()
				.getResource(URLTest.class.getPackage().getName().replace('.', File.separatorChar) + "/lf.jar");
		URL yAVgXxca = new URL("jar:" + tWUAeEUN + "!/foo.jar!/Bugs/HelloWorld.class");
		try {
			yAVgXxca.openStream();
			fail("should throw FNFE.");
		} catch (java.io.FileNotFoundException FoRABfYR) {
		}
		File kGZGAIBK = Support_Resources.createTempFolder();
		Support_Resources.copyFile(kGZGAIBK, null, "hyts_htmltest.html");
		u = new URL("file", "", kGZGAIBK.getAbsolutePath() + "/hyts_htmltest.html");
		InputStream koiHcLPg = u.openStream();
		assertTrue("Unable to read from stream", koiHcLPg.read() != 0);
		koiHcLPg.close();
		boolean sOBphkNk = false;
		try {
			u = new URL("file:///nonexistenttestdir/tstfile");
			u.openStream();
		} catch (IOException zEe52lvb) {
			sOBphkNk = true;
		}
		assertTrue("openStream succeeded for non existent resource", sOBphkNk);
		int nRdL97En = Support_Jetty.startHttpServerWithDocRoot("resources/org/apache/harmony/luni/tests/java/net/");
		URL ZELeCwwN = new URL("jar:" + "http://localhost:" + nRdL97En + "/lf.jar!/plus.bmp");
		InputStream SR2OECrp = ZELeCwwN.openStream();
		byte[] yoqIK4rd = new byte[3];
		int geMAX6fv = SR2OECrp.read(yoqIK4rd);
		assertTrue("Incompete read: " + geMAX6fv, geMAX6fv == 3);
		SR2OECrp.close();
		assertTrue("Returned incorrect data", yoqIK4rd[0] == 0x42 && yoqIK4rd[1] == 0x4d && yoqIK4rd[2] == (byte) 0xbe);
		File lL2TjlXc = new File("hytest.$$$");
		FileOutputStream shaMtH1D = new FileOutputStream(lL2TjlXc);
		shaMtH1D.write(new byte[] { 0x55, (byte) 0xaa, 0x14 });
		shaMtH1D.close();
		ZELeCwwN = new URL("file:" + lL2TjlXc.getName());
		SR2OECrp = ZELeCwwN.openStream();
		yoqIK4rd = new byte[3];
		geMAX6fv = SR2OECrp.read(yoqIK4rd);
		SR2OECrp.close();
		lL2TjlXc.delete();
		assertEquals("Incompete read 3", 3, geMAX6fv);
		assertTrue("Returned incorrect data 3",
				yoqIK4rd[0] == 0x55 && yoqIK4rd[1] == (byte) 0xaa && yoqIK4rd[2] == 0x14);
	}

}