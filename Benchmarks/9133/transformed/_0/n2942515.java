class n2942515 {
	@Override
	protected InputStream getResourceStream(String u64FFIFF) throws Exception {
		final BundleEntry Y4H6DlJm = cpm.findLocalEntry(u64FFIFF);
		if (Y4H6DlJm != null)
			return Y4H6DlJm.getInputStream();
		final URL su4lpPuJ = cpm.getBaseData().getBundle().getResource(u64FFIFF);
		if (su4lpPuJ != null)
			return su4lpPuJ.openStream();
		return null;
	}

}