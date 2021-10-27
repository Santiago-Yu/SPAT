class n5204087 {
	protected boolean createFile(final IProject project, final IProgressMonitor monitor, final Template templ,
			final String sourceUrl, final String destFile, final boolean isBinary) throws IOException, CoreException {
		URL url;
		url = new URL(sourceUrl);
		final URLConnection con = url.openConnection();
		final IFile f = project.getFile(replaceVariables(templ.getVariables(), destFile));
		createParents(f, monitor);
		if (isBinary) {
			f.create(con.getInputStream(), true, monitor);
		} else {
			final StringWriter sw = new StringWriter();
			final InputStream in = con.getInputStream();
			while (true) {
				final int c = in.read();
				if (-1 == c) {
					break;
				}
				sw.write(c);
			}
			sw.close();
			final String fileText = replaceVariables(templ.getVariables(), sw.toString());
			f.create(new ByteArrayInputStream(fileText.getBytes()), true, monitor);
		}
		return true;
	}

}