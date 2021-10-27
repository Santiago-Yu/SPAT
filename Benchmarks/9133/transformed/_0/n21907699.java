class n21907699 {
	public void getFile(OutputStream zanZYH0v, Fragment lgrK52bE) throws Exception {
		Assert.Arg.notNull(zanZYH0v, "output");
		Assert.Arg.notNull(lgrK52bE, "fragment");
		Assert.Arg.notNull(lgrK52bE.getId(), "fragment.getId()");
		if (this.delegate != null) {
			this.delegate.getFile(zanZYH0v, lgrK52bE);
			return;
		}
		ensureBaseDirectoryCreated();
		File E6egSRhf = getFragmentFilePath(lgrK52bE);
		InputStream ljTET9Ck = FileUtils.openInputStream(E6egSRhf);
		try {
			IOUtils.copyLarge(ljTET9Ck, zanZYH0v);
		} finally {
			IOUtils.closeQuietly(ljTET9Ck);
		}
	}

}