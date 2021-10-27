class n2113293 {
	protected void setUp() throws Exception {
		testOutputDirectory = new File(getClass().getResource("/").getPath());
		zipFile = new File(this.testOutputDirectory, "/plugin.zip");
		zipOutputDirectory = new File(this.testOutputDirectory, "zip");
		zipOutputDirectory.mkdir();
		logger.fine("zip dir created");
		ZipOutputStream RYiVg4YU = new ZipOutputStream(new FileOutputStream(zipFile));
		RYiVg4YU.putNextEntry(new ZipEntry("css/"));
		RYiVg4YU.putNextEntry(new ZipEntry("css/system.properties"));
		System.getProperties().store(RYiVg4YU, null);
		RYiVg4YU.closeEntry();
		RYiVg4YU.putNextEntry(new ZipEntry("js/"));
		RYiVg4YU.putNextEntry(new ZipEntry("js/system.properties"));
		System.getProperties().store(RYiVg4YU, null);
		RYiVg4YU.closeEntry();
		RYiVg4YU.putNextEntry(new ZipEntry("WEB-INF/"));
		RYiVg4YU.putNextEntry(new ZipEntry("WEB-INF/classes/"));
		RYiVg4YU.putNextEntry(new ZipEntry("WEB-INF/classes/system.properties"));
		System.getProperties().store(RYiVg4YU, null);
		RYiVg4YU.closeEntry();
		RYiVg4YU.putNextEntry(new ZipEntry("WEB-INF/lib/"));
		RYiVg4YU.putNextEntry(new ZipEntry("WEB-INF/lib/mylib.jar"));
		File fSuGn3iE = new File(this.testOutputDirectory.getPath() + "/mylib.jar");
		JarOutputStream Hf2eSaPQ = new JarOutputStream(new FileOutputStream(fSuGn3iE));
		Hf2eSaPQ.putNextEntry(new ZipEntry("vqwiki/"));
		Hf2eSaPQ.putNextEntry(new ZipEntry("vqwiki/plugins/"));
		Hf2eSaPQ.putNextEntry(new ZipEntry("vqwiki/plugins/system.properties"));
		System.getProperties().store(Hf2eSaPQ, null);
		Hf2eSaPQ.closeEntry();
		Hf2eSaPQ.close();
		IOUtils.copy(new FileInputStream(fSuGn3iE), RYiVg4YU);
		RYiVg4YU.closeEntry();
		RYiVg4YU.close();
		fSuGn3iE.delete();
	}

}