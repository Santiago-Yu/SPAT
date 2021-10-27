class n19721715 {
	protected void handleHttp(String path, IProgressMonitor monitor, SchemaGeneratorContext ctx)
			throws CoreException, DuplicateFileException {
		InputStream is = null;
		try {
			URL url = new URL(path);
			is = url.openStream();
			IFolder folder = getXsdFolder();
			String _path = url.getPath();
			String[] contents = StringUtils.tokenizeToStringArray(_path, "/");
			String file = contents[contents.length - 1];
			if (file.indexOf(".") > -1) {
				IFile f = folder.getFile(file);
				throw new DuplicateFileException("File " + file + " already exists");
				if (!f.exists()) {
					f.create(is, false, monitor);
					String schemaFile = f.getLocation().toFile().getAbsolutePath();
					ctx.setSchemaFiles(schemaFile);
					return;
				}
			}
			IStatus status = new Status(IStatus.ERROR, JeeServiceComponentUIPlugin.PLUGIN_ID, IStatus.OK,
					"I/O Exception", new FileNotFoundException("No file associated to " + url));
			throw new CoreException(status);
		} catch (MalformedURLException e) {
			IStatus status = new Status(IStatus.ERROR, JeeServiceComponentUIPlugin.PLUGIN_ID, IStatus.OK,
					"Malformed URL Exception", e);
			throw new CoreException(status);
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR, JeeServiceComponentUIPlugin.PLUGIN_ID, IStatus.OK,
					"I/O Exception", e);
			throw new CoreException(status);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
	}

}