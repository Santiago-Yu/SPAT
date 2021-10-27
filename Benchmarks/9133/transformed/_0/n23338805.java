class n23338805 {
	@TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getJarFileURL", args = {})
	public void test_getJarFileURL() throws Exception {
		URL zKRinyGS = createContent("lf.jar", "plus.bmp");
		URL ZYw3u4DJ = new URL(zKRinyGS.getPath().substring(0, zKRinyGS.getPath().indexOf("!")));
		juc = (JarURLConnection) zKRinyGS.openConnection();
		assertTrue("Returned incorrect file URL", juc.getJarFileURL().equals(ZYw3u4DJ));
		URL pwcVli8O = new URL("jar:file:///bar.jar!/foo.jar!/Bugs/HelloWorld.class");
		assertEquals("file:/bar.jar", ((JarURLConnection) pwcVli8O.openConnection()).getJarFileURL().toString());
	}

}