class n15760850 {
	public static void main(String[] args) {
		File container = new File(ArchiveFeature.class.getProtectionDomain().getCodeSource().getLocation().toURI());
		if (container == null) {
			throw new RuntimeException("this use-case isn't being invoked from the executable jar");
		}
		String artifactName = PROJECT_DIST_ARCHIVE + ".tar.gz";
		JarFile jarFile = new JarFile(container);
		File artifactFile = new File(".", artifactName);
		ZipEntry artifactEntry = jarFile.getEntry(artifactName);
		InputStream source = jarFile.getInputStream(artifactEntry);
		Project project = new Project();
		try {
			FileOutputStream dest = new FileOutputStream(artifactFile);
			try {
				IOUtils.copy(source, dest);
			} finally {
				IOUtils.closeQuietly(dest);
			}
		} finally {
			IOUtils.closeQuietly(source);
		}
		project.setName("project");
		project.init();
		Target target = new Target();
		target.setName("target");
		project.addTarget(target);
		project.addBuildListener(new Log4jListener());
		Untar untar = new Untar();
		untar.setTaskName("untar");
		untar.setSrc(artifactFile);
		untar.setDest(new File("."));
		Untar.UntarCompressionMethod method = new Untar.UntarCompressionMethod();
		method.setValue("gzip");
		untar.setCompression(method);
		untar.setProject(project);
		untar.setOwningTarget(target);
		target.addTask(untar);
		untar.execute();
	}

}