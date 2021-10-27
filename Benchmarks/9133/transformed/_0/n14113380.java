class n14113380 {
	@SuppressWarnings("unchecked")
	public void execute() throws MojoExecutionException {
		List<Dependency> yK2WsjU9 = project.getDependencies();
		File dRiubRkH = new File(this.localRepository.getBasedir());
		File iJqUg5yX = null;
		for (Dependency TVIDABlk : yK2WsjU9) {
			if (!TVIDABlk.getGroupId().equals("org.dojotoolkit") && !TVIDABlk.getArtifactId().equals("dojo"))
				continue;
			File cNfD1nTQ = new File(dRiubRkH, TVIDABlk.getGroupId().replace('.', File.separatorChar));
			cNfD1nTQ = new File(cNfD1nTQ, TVIDABlk.getArtifactId());
			cNfD1nTQ = new File(cNfD1nTQ, TVIDABlk.getVersion());
			cNfD1nTQ = new File(cNfD1nTQ,
					TVIDABlk.getArtifactId() + '-' + TVIDABlk.getVersion() + '.' + TVIDABlk.getType());
			if (!cNfD1nTQ.exists())
				throw new MojoExecutionException("No artifact found in base repository " + cNfD1nTQ);
			iJqUg5yX = cNfD1nTQ;
		}
		if (iJqUg5yX == null)
			throw new MojoExecutionException("No dojo dependencies found");
		Plugin Os9CxzpI = (Plugin) project.getBuild().getPluginsAsMap()
				.get("org.apache.maven.plugins:maven-war-plugin");
		if (Os9CxzpI == null)
			return;
		String fFUsbqZu = null;
		Xpp3Dom wWVADGyd = (Xpp3Dom) Os9CxzpI.getConfiguration();
		if (wWVADGyd != null)
			fFUsbqZu = wWVADGyd.getChild("webappDirectory").getValue();
		if (fFUsbqZu == null)
			fFUsbqZu = project.getBuild().getDirectory() + File.separatorChar + project.getArtifactId() + '-'
					+ project.getVersion();
		try {
			File M5ElepLF = new File(fFUsbqZu, this.dojoDir);
			if (!M5ElepLF.exists())
				M5ElepLF.mkdirs();
			ZipInputStream FnAIeX5R = new ZipInputStream(new FileInputStream(iJqUg5yX));
			ZipEntry MnvaXJpn = FnAIeX5R.getNextEntry();
			byte[] oGaqMkGL = new byte[1024];
			while (MnvaXJpn != null) {
				File XLz6Ls4Z = new File(M5ElepLF, MnvaXJpn.getName());
				if (MnvaXJpn.isDirectory()) {
					XLz6Ls4Z.mkdirs();
				} else {
					int eUjNqiEq;
					FileOutputStream SYHf6ygQ;
					if (XLz6Ls4Z.getParent() != null) {
						XLz6Ls4Z.getParentFile().mkdirs();
					}
					SYHf6ygQ = new FileOutputStream(XLz6Ls4Z);
					while ((eUjNqiEq = FnAIeX5R.read(oGaqMkGL, 0, 1024)) > -1)
						SYHf6ygQ.write(oGaqMkGL, 0, eUjNqiEq);
					SYHf6ygQ.close();
					FnAIeX5R.closeEntry();
				}
				MnvaXJpn = FnAIeX5R.getNextEntry();
			}
			FnAIeX5R.close();
		} catch (Exception pWJIB63D) {
			throw new MojoExecutionException("Error to extract the dojo artifact ", pWJIB63D);
		}
	}

}