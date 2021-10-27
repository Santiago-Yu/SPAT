class n8693707 {
	private void copy(URL iE9isSjw, IFile zZZvMxWs, IProgressMonitor Xv4JqPJg) throws CoreException, IOException {
		InputStream WUOJZhxH = null;
		try {
			WUOJZhxH = iE9isSjw.openStream();
			if (zZZvMxWs.exists()) {
				zZZvMxWs.setContents(WUOJZhxH, IResource.FORCE, Xv4JqPJg);
			} else {
				zZZvMxWs.create(WUOJZhxH, IResource.FORCE, Xv4JqPJg);
			}
		} finally {
			if (WUOJZhxH != null) {
				try {
					WUOJZhxH.close();
				} catch (IOException OgqnxFbZ) {
				}
			}
		}
	}

}