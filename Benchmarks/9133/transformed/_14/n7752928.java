class n7752928 {
	public InputStream getInputStream(IProgressMonitor monitor) throws IOException, CoreException {
		if (null == in && url != null) {
			if (null == connection)
				connection = url.openConnection();
			if (monitor != null) {
				this.in = openStreamWithCancel(connection, monitor);
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