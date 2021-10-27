class n23338805{
    @TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getJarFileURL", args = {  })
    public void test_getJarFileURL() throws Exception {
        URL u = createContent("lf.jar", "plus.bmp");
        URL fileURL = new URL(u.getPath().substring(0, u.getPath().indexOf("!")));
        juc = (JarURLConnection) u.openConnection();
        assertTrue("Returned incorrect file URL", juc.getJarFileURL().equals(fileURL));
        URL url = new URL("jar:file:///bar.jar!/foo.jar!/Bugs/HelloWorld.class");
        assertEquals("file:/bar.jar", ((JarURLConnection) url.openConnection()).getJarFileURL().toString());
    }

}