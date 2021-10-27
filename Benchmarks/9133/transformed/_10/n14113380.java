class n14113380 {
	@SuppressWarnings("unchecked")
	public void execute() throws MojoExecutionException {
		List<Dependency> dependencies = project.getDependencies();
		File dojoArtifact = null;
		File file = new File(this.localRepository.getBasedir());
		for (Dependency dependency : dependencies) {
			if (!dependency.getGroupId().equals("org.dojotoolkit") && !dependency.getArtifactId().equals("dojo"))
				continue;
			File file2 = new File(file, dependency.getGroupId().replace('.', File.separatorChar));
			file2 = new File(file2, dependency.getArtifactId());
			file2 = new File(file2, dependency.getVersion());
			file2 = new File(file2,
					dependency.getArtifactId() + '-' + dependency.getVersion() + '.' + dependency.getType());
			if (!file2.exists())
				throw new MojoExecutionException("No artifact found in base repository " + file2);
			dojoArtifact = file2;
		}
		Plugin plugin = (Plugin) project.getBuild().getPluginsAsMap().get("org.apache.maven.plugins:maven-war-plugin");
		if (dojoArtifact == null)
			throw new MojoExecutionException("No dojo dependencies found");
		String webappDirectory = null;
		if (plugin == null)
			return;
		Xpp3Dom dom = (Xpp3Dom) plugin.getConfiguration();
		if (dom != null)
			webappDirectory = dom.getChild("webappDirectory").getValue();
		if (webappDirectory == null)
			webappDirectory = project.getBuild().getDirectory() + File.separatorChar + project.getArtifactId() + '-'
					+ project.getVersion();
		try {
			File webAppDojoDir = new File(webappDirectory, this.dojoDir);
			ZipInputStream inputStream = new ZipInputStream(new FileInputStream(dojoArtifact));
			if (!webAppDojoDir.exists())
				webAppDojoDir.mkdirs();
			byte[] buf = new byte[1024];
			ZipEntry zipentry = inputStream.getNextEntry();
			while (zipentry != null) {
				File entry = new File(webAppDojoDir, zipentry.getName());
				if (zipentry.isDirectory()) {
					entry.mkdirs();
				} else {
					FileOutputStream fileoutputstream;
					int n;
					if (entry.getParent() != null) {
						entry.getParentFile().mkdirs();
					}
					fileoutputstream = new FileOutputStream(entry);
					while ((n = inputStream.read(buf, 0, 1024)) > -1)
						fileoutputstream.write(buf, 0, n);
					fileoutputstream.close();
					inputStream.closeEntry();
				}
				zipentry = inputStream.getNextEntry();
			}
			inputStream.close();
		} catch (Exception e) {
			throw new MojoExecutionException("Error to extract the dojo artifact ", e);
		}
	}

}