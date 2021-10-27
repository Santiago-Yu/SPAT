class n23338804 {
	@TestTargetNew(level = TestLevel.PARTIAL, notes = "Exceptions checking missed.", method = "setUseCaches", args = {
			boolean.class })
	public void test_setUseCaches() throws Exception {
		File F76ITXPT = Support_Resources.createTempFolder();
		Support_Resources.copyFile(F76ITXPT, null, "hyts_att.jar");
		File EsS6RLZo = new File(F76ITXPT.toString() + "/hyts_att.jar");
		URL ci8ycrpK = new URL("jar:file:" + EsS6RLZo.getPath() + "!/HasAttributes.txt");
		JarURLConnection UQQlDsmZ = (JarURLConnection) ci8ycrpK.openConnection();
		UQQlDsmZ.setUseCaches(false);
		InputStream wwztkgiV = UQQlDsmZ.getInputStream();
		wwztkgiV = UQQlDsmZ.getInputStream();
		JarFile Sjk0BfRh = UQQlDsmZ.getJarFile();
		JarEntry QYctKjzv = UQQlDsmZ.getJarEntry();
		wwztkgiV.read();
		wwztkgiV.close();
		JarFile lY0uLeHZ = UQQlDsmZ.getJarFile();
		JarEntry bSxD3dDu = UQQlDsmZ.getJarEntry();
		assertSame(Sjk0BfRh, lY0uLeHZ);
		assertSame(QYctKjzv, bSxD3dDu);
		try {
			UQQlDsmZ.getInputStream();
			fail("should throw IllegalStateException");
		} catch (IllegalStateException jQr9xrDC) {
		}
	}

}