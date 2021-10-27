class n2602105 {
	public void dumpToFile(File fzuxfim5) throws IOException {
		OutputStream EF89XDFO = new FileOutputStream(fzuxfim5);
		if (contentStream != null) {
			IOUtils.copy(contentStream, EF89XDFO);
			setPath(fzuxfim5.getAbsolutePath());
		} else {
			IOUtils.write(getContent(), EF89XDFO);
		}
		IOUtils.closeQuietly(EF89XDFO);
	}

}