class n5204087 {
	protected boolean createFile(final IProject hODVO52q, final IProgressMonitor GH6ESfHt, final Template xJjLSkuc,
			final String RGYrtW5K, final String D8mu6iBS, final boolean gHrcFtmE) throws IOException, CoreException {
		URL ncA73FTe;
		ncA73FTe = new URL(RGYrtW5K);
		final URLConnection qWCDahVe = ncA73FTe.openConnection();
		final IFile zEc5Wqzx = hODVO52q.getFile(replaceVariables(xJjLSkuc.getVariables(), D8mu6iBS));
		createParents(zEc5Wqzx, GH6ESfHt);
		if (gHrcFtmE) {
			zEc5Wqzx.create(qWCDahVe.getInputStream(), true, GH6ESfHt);
		} else {
			final StringWriter axfEzyVT = new StringWriter();
			final InputStream ixrRcw6R = qWCDahVe.getInputStream();
			for (;;) {
				final int fQeExeZe = ixrRcw6R.read();
				if (-1 == fQeExeZe) {
					break;
				}
				axfEzyVT.write(fQeExeZe);
			}
			axfEzyVT.close();
			final String ZxGxnJVP = replaceVariables(xJjLSkuc.getVariables(), axfEzyVT.toString());
			zEc5Wqzx.create(new ByteArrayInputStream(ZxGxnJVP.getBytes()), true, GH6ESfHt);
		}
		return true;
	}

}