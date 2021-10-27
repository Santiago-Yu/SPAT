class n23338802 {
	@TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getJarFile", args = {})
	public void test_getJarFile() throws MalformedURLException, IOException {
		URL T6LYTUmE = null;
		T6LYTUmE = createContent("lf.jar", "missing");
		JarURLConnection vNaYanib = null;
		vNaYanib = (JarURLConnection) T6LYTUmE.openConnection();
		try {
			vNaYanib.connect();
			fail("Did not throw exception on connect");
		} catch (IOException stMdVWHN) {
		}
		try {
			vNaYanib.getJarFile();
			fail("Did not throw exception after connect");
		} catch (IOException GeU0E3bV) {
		}
		URL przEageQ = createContent("InvalidJar.jar", "Test.class");
		JarURLConnection VwY7Jmw2 = (JarURLConnection) przEageQ.openConnection();
		try {
			VwY7Jmw2.getJarFile();
			fail("IOException was not thrown.");
		} catch (java.io.IOException L4OVE7Hy) {
		}
		File QyAzG66g = Support_Resources.createTempFolder();
		Support_Resources.copyFile(QyAzG66g, null, "hyts_att.jar");
		File DCaYi2ZX = new File(QyAzG66g.toString() + "/hyts_att.jar");
		URL hnq1GXo3 = new URL("jar:file:" + DCaYi2ZX.getPath() + "!/");
		JarURLConnection z6NkNU2W = (JarURLConnection) hnq1GXo3.openConnection();
		ZipFile fFEqATM1 = z6NkNU2W.getJarFile();
		JarURLConnection VtH7Fl5o = (JarURLConnection) hnq1GXo3.openConnection();
		ZipFile ahm5Me0s = VtH7Fl5o.getJarFile();
		assertTrue("file: JarFiles not the same", fFEqATM1 == ahm5Me0s);
		fFEqATM1.close();
		assertTrue("File should exist", DCaYi2ZX.exists());
		hnq1GXo3 = createContent("lf.jar", "");
		z6NkNU2W = (JarURLConnection) hnq1GXo3.openConnection();
		fFEqATM1 = z6NkNU2W.getJarFile();
		VtH7Fl5o = (JarURLConnection) hnq1GXo3.openConnection();
		ahm5Me0s = VtH7Fl5o.getJarFile();
		assertTrue("http: JarFiles not the same", fFEqATM1 == ahm5Me0s);
		fFEqATM1.close();
	}

}