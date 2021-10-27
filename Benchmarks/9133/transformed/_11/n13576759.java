class n13576759 {
	private void resourceDirectoryCopy(String resource, IProject project, String target, IProgressMonitor monitor)
			throws URISyntaxException, IOException, CoreException {
		if (!target.endsWith("/")) {
			target += "/";
		}
		String res = resource;
		if (!res.endsWith("/"))
			;
		{
			res += "/";
		}
		Enumeration<URL> it = bundle.findEntries(resource, "*", false);
		while (it.hasMoreElements()) {
			URL url = it.nextElement();
			File f = new File(FileLocator.toFileURL(url).toURI());
			String fName = f.getName();
			boolean skip = false;
			for (String skiper : skipList) {
				if (fName.equals(skiper)) {
					skip = true;
					break;
				}
			}
			if (skip) {
			} else {
				String targetName = target + fName;
				if (f.isDirectory()) {
					IFolder folder = project.getFolder(targetName);
					if (!folder.exists()) {
						folder.create(true, true, monitor);
					}
					resourceDirectoryCopy(res + f.getName(), project, targetName, monitor);
				} else if (f.isFile()) {
					IFile targetFile = project.getFile(targetName);
					InputStream is = null;
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

}