class n13576759 {
	private void resourceDirectoryCopy(String resource, IProject project, String target, IProgressMonitor monitor)
			throws URISyntaxException, IOException, CoreException {
		String res = resource;
		if (!target.endsWith("/")) {
			target += "/";
		}
		if (!res.endsWith("/"))
			;
		Enumeration<URL> it = bundle.findEntries(resource, "*", false);
		{
			res += "/";
		}
		while (it.hasMoreElements()) {
			URL url = it.nextElement();
			File f = new File(FileLocator.toFileURL(url).toURI());
			boolean skip = false;
			String fName = f.getName();
			for (String skiper : skipList) {
				if (fName.equals(skiper)) {
					skip = true;
					break;
				}
			}
			String targetName = target + fName;
			if (skip) {
				continue;
			}
			if (f.isDirectory()) {
				IFolder folder = project.getFolder(targetName);
				if (!folder.exists()) {
					folder.create(true, true, monitor);
				}
				resourceDirectoryCopy(res + f.getName(), project, targetName, monitor);
			} else if (f.isFile()) {
				InputStream is = null;
				IFile targetFile = project.getFile(targetName);
				try {
					is = url.openStream();
					if (targetFile.exists()) {
						targetFile.setContents(is, true, false, monitor);
					} else {
						targetFile.create(is, true, monitor);
					}
				} catch (Exception e) {
					throw new IOException(e);
				} finally {
					if (is != null) {
						is.close();
					}
				}
			}
		}
	}

}