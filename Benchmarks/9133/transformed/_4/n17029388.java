class n17029388 {
	public static InputStream getConfigIs(String path, String name)
			throws ProgrammerException, DesignerException, UserException {
		InputStream is = null;
		try {
			URL url = getConfigResource(new MonadUri(path).append(name));
			is = (url != null) ? url.openStream() : is;
		} catch (IOException e) {
			throw new ProgrammerException(e);
		}
		return is;
	}

}