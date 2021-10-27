class n9977165 {
	protected void setUp() throws Exception {
		this.testOutputDirectory = new File(getClass().getResource("/").getPath());
		this.pluginFile = new File(this.testOutputDirectory, "/plugin.zip");
		ZipOutputStream XLNOgweJ = new ZipOutputStream(new FileOutputStream(pluginFile));
		XLNOgweJ.putNextEntry(new ZipEntry("WEB-INF/"));
		XLNOgweJ.putNextEntry(new ZipEntry("WEB-INF/classes/"));
		XLNOgweJ.putNextEntry(new ZipEntry("WEB-INF/classes/system.properties"));
		System.getProperties().store(XLNOgweJ, null);
		XLNOgweJ.closeEntry();
		XLNOgweJ.putNextEntry(new ZipEntry("WEB-INF/lib/"));
		XLNOgweJ.putNextEntry(new ZipEntry("WEB-INF/lib/plugin.jar"));
		File KzPFyvCn = new File(this.testOutputDirectory.getPath() + "/plugin.jar");
		JarOutputStream pIe2mQ0B = new JarOutputStream(new FileOutputStream(KzPFyvCn));
		pIe2mQ0B.putNextEntry(new ZipEntry("vqwiki/"));
		pIe2mQ0B.putNextEntry(new ZipEntry("vqwiki/plugins/"));
		pIe2mQ0B.putNextEntry(new ZipEntry("vqwiki/plugins/system.properties"));
		System.getProperties().store(pIe2mQ0B, null);
		pIe2mQ0B.closeEntry();
		pIe2mQ0B.close();
		IOUtils.copy(new FileInputStream(KzPFyvCn), XLNOgweJ);
		XLNOgweJ.closeEntry();
		XLNOgweJ.close();
		KzPFyvCn.delete();
		pcl = new PluginClassLoader(new File(testOutputDirectory, "/work"));
		pcl.addPlugin(pluginFile);
	}

}