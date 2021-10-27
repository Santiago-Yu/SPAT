class n19721715 {
	protected void handleHttp(String HYjV3FbC, IProgressMonitor oLfBGJjU, SchemaGeneratorContext snfLlUXX)
			throws CoreException, DuplicateFileException {
		InputStream efUJbefK = null;
		try {
			URL Juql0YnS = new URL(HYjV3FbC);
			efUJbefK = Juql0YnS.openStream();
			IFolder f8gelOaI = getXsdFolder();
			String eNEtiVVZ = Juql0YnS.getPath();
			String[] KE0hnj83 = StringUtils.tokenizeToStringArray(eNEtiVVZ, "/");
			String ZuRmTzQw = KE0hnj83[KE0hnj83.length - 1];
			if (ZuRmTzQw.indexOf(".") > -1) {
				IFile LNi2Txjj = f8gelOaI.getFile(ZuRmTzQw);
				if (!LNi2Txjj.exists()) {
					LNi2Txjj.create(efUJbefK, false, oLfBGJjU);
					String FMEJ5Lx9 = LNi2Txjj.getLocation().toFile().getAbsolutePath();
					snfLlUXX.setSchemaFiles(FMEJ5Lx9);
					return;
				}
				throw new DuplicateFileException("File " + ZuRmTzQw + " already exists");
			}
			IStatus xQJ6vB38 = new Status(IStatus.ERROR, JeeServiceComponentUIPlugin.PLUGIN_ID, IStatus.OK,
					"I/O Exception", new FileNotFoundException("No file associated to " + Juql0YnS));
			throw new CoreException(xQJ6vB38);
		} catch (MalformedURLException WknR3x6F) {
			IStatus s1gf5tZZ = new Status(IStatus.ERROR, JeeServiceComponentUIPlugin.PLUGIN_ID, IStatus.OK,
					"Malformed URL Exception", WknR3x6F);
			throw new CoreException(s1gf5tZZ);
		} catch (IOException LK95eOYw) {
			IStatus aL0g5cvw = new Status(IStatus.ERROR, JeeServiceComponentUIPlugin.PLUGIN_ID, IStatus.OK,
					"I/O Exception", LK95eOYw);
			throw new CoreException(aL0g5cvw);
		} finally {
			if (efUJbefK != null) {
				try {
					efUJbefK.close();
				} catch (IOException ex5KszDE) {
				}
			}
		}
	}

}