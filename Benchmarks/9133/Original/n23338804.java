class n23338804{
    @TestTargetNew(level = TestLevel.PARTIAL, notes = "Exceptions checking missed.", method = "setUseCaches", args = { boolean.class })
    public void test_setUseCaches() throws Exception {
        File resources = Support_Resources.createTempFolder();
        Support_Resources.copyFile(resources, null, "hyts_att.jar");
        File file = new File(resources.toString() + "/hyts_att.jar");
        URL url = new URL("jar:file:" + file.getPath() + "!/HasAttributes.txt");
        JarURLConnection connection = (JarURLConnection) url.openConnection();
        connection.setUseCaches(false);
        InputStream in = connection.getInputStream();
        in = connection.getInputStream();
        JarFile jarFile1 = connection.getJarFile();
        JarEntry jarEntry1 = connection.getJarEntry();
        in.read();
        in.close();
        JarFile jarFile2 = connection.getJarFile();
        JarEntry jarEntry2 = connection.getJarEntry();
        assertSame(jarFile1, jarFile2);
        assertSame(jarEntry1, jarEntry2);
        try {
            connection.getInputStream();
            fail("should throw IllegalStateException");
        } catch (IllegalStateException e) {
        }
    }

}