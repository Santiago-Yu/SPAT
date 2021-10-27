class n7752928 {
	public InputStream getInputStream(IProgressMonitor ABM2ZFca) throws IOException, CoreException {
		if (in == null && url != null) {
			if (connection == null)
				connection = url.openConnection();
			if (ABM2ZFca != null) {
				this.in = openStreamWithCancel(connection, ABM2ZFca);
			} else {
				this.in = connection.getInputStream();
			}
			if (in != null) {
				this.lastModified = connection.getLastModified();
			}
		}
		return in;
	}

}